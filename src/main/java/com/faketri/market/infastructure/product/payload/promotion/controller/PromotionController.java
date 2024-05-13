package com.faketri.market.infastructure.product.payload.promotion.controller;


import com.faketri.market.entity.image.model.Image;
import com.faketri.market.entity.product.payload.promotion.model.Promotion;
import com.faketri.market.infastructure.product.payload.promotion.gateway.PromotionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;


/**
 * The type Promotion controller.
 *
 * @author Dmitriy Faketri
 */
@RestController()
@CrossOrigin({"http://localhost:8081", "http://192.168.1.106:8081/"})
@RequestMapping(path = "/api/promotion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Promotion", description = "Operation with promotion")
public class PromotionController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @RequestMapping("/")
    public List<Promotion> getAll() {
        return promotionService.findAll();
    }

    /**
     * Find by id promotion.
     *
     * @param id the id
     * @return the promotion
     */
    @RequestMapping("/{id}")
    public Promotion findById(@PathVariable("id") UUID id) {
        return promotionService.findById(id);
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Promotion save(
            @Valid @RequestPart("promo") final Promotion promotionCreateRequest,
            @RequestPart("images")  final MultipartFile images) {
        Promotion promotion = new Promotion();

        promotion.setDescription(promotionCreateRequest.getDescription());
        promotion.setPromotionProductItems(promotionCreateRequest.getPromotionProductItems());
        promotion.setDateOfStart(promotionCreateRequest.getDateOfStart());
        promotion.setDateOfEnd(promotionCreateRequest.getDateOfEnd());
        promotion.setTitle(promotionCreateRequest.getTitle());

        final String path = "/app/images/";
        final String imageName = path + promotion.getTitle().replace(' ', '-')  + "-" + images.getOriginalFilename();

        try {
            images.transferTo(Paths.get(imageName));
        } catch (IOException e) {
            log.error(this.getClass() + " " + e.getMessage());
        }
        promotion.setBanner(new Image(null, imageName));


        return promotionService.save(promotion);
    }

}
