package com.faketri.market.infastructure.user.payload.user.controller;

import com.faketri.market.entity.image.model.Image;
import com.faketri.market.entity.product.payload.product.model.Product;
import com.faketri.market.entity.product.payload.product.model.ProductItem;
import com.faketri.market.entity.user.payload.order.gateway.mapper.OrderMapper;
import com.faketri.market.entity.user.payload.order.model.Orders;
import com.faketri.market.entity.user.payload.user.model.Users;
import com.faketri.market.infastructure.image.gateway.ImageService;
import com.faketri.market.infastructure.user.payload.order.dto.OrdersDto;
import com.faketri.market.infastructure.user.payload.user.dto.UserUpdateRequest;
import com.faketri.market.infastructure.user.payload.user.gateway.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

/**
 * The type Post controller.
 *
 * @author Dmitriy Faketri
 */
@RestController
@CrossOrigin({"http://localhost:8081", "http://192.168.1.106:8081/"})
@RequestMapping(path = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
public class UserPostController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;
    private final ImageService imageService;

    @Autowired
    public UserPostController(UserService userService, ImageService imageService) {
        this.userService = userService;
        this.imageService = imageService;
    }

    @RequestMapping(value = "/profile/image/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Image updateUserImage(@RequestBody final MultipartFile image) {
        final Users user = userService.getCurrentUser();

        final String path = "/app/images/user/profile/";
        final String name = user.getLogin().replace(' ', '-');

        final String imageName = path + name + "-" + Objects.requireNonNull(image.getOriginalFilename()).replace(' ', '-').toLowerCase();
        System.out.println(imageName);
        try {
            image.transferTo(Paths.get(imageName));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        final Image deleteImage = user.getProfileImage();
        user.setProfileImage(new Image(null, imageName));

        // Сохраняем пользователя и получаем управляемую сущность с обновленным профилем изображения
        final Users savedUser = userService.save(user);
        final Image returnedImage = savedUser.getProfileImage();

        // Удаляем предыдущее изображение
        imageService.delete(deleteImage);
        return returnedImage;
    }

    @RequestMapping("/profile/update")
    public void updateUserData(@RequestBody final UserUpdateRequest userUpdateRequest) {
        final Users user = userService.getCurrentUser();

        user.setName(userUpdateRequest.getFirstName());
        user.setSurname(userUpdateRequest.getLastName());
        user.setDateOfBirthday(userUpdateRequest.getDateOfBirthday());
        user.setEmail(userUpdateRequest.getEmail());

        userService.save(user);
    }

    @RequestMapping("/like/product")
    public void likeProduct(@RequestBody final Product product) {
        log.info("LIKE PROD " + product.getId());
        Users user = userService.getCurrentUser();
        user.getFavoriteProduct().add(product);
        userService.save(user);
    }

    @RequestMapping("/dislike/product")
    public void dislikeProduct(@RequestBody final Product product) {
        log.info("DISLIKE PROD " + product.getId());
        Users user = userService.getCurrentUser();
        user.getFavoriteProduct().remove(product);
        userService.save(user);
    }
}
