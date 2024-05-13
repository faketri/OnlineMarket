package com.faketri.market.infastructure.product.payload.product.controller;

import com.faketri.market.entity.image.model.Image;
import com.faketri.market.entity.product.payload.characteristics.model.Characteristics;
import com.faketri.market.entity.product.payload.product.model.Product;
import com.faketri.market.infastructure.product.payload.product.dto.ProductCreateRequest;
import com.faketri.market.infastructure.product.payload.product.gateway.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Product controller.
 *
 * @author Dmitriy Faketri
 */
@RestController()
@CrossOrigin({"http://localhost:8081", "http://192.168.1.106:8081/"})
@RequestMapping(value = "/api/product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Product", description = "Operation with product")
public class ProductPostController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final ProductService productService;
    private final String root = new ClassPathResource("/images/").getPath();

    /**
     * Instantiates a new Product controller.
     *
     * @param productService the product service
     */
    public ProductPostController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Gets by filter.
     *
     * @param categoriesId the categories id
     * @param pageNumber   the page number
     * @param pageSize     the page size
     * @param filter       the filter
     * @return the by filter
     */
    @RequestMapping("/categories/{categoriesId}")
    public Page<Product> getByFilter(
            @PathVariable(value = "categoriesId") UUID categoriesId,
            @RequestParam(name = "number", required = true,
                    defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "size", required = true,
                    defaultValue = "20") Integer pageSize,
            /*@RequestPart(value = "name", required = false) String name,
            @RequestPart(value = "brand", required = false) Brand brand,*/
            @RequestBody List<Characteristics> filter
    ) {
        log.info("Get product with filer, filter : " + filter.stream()
                .map(item -> item.getName() + ": " + item.getValue())
                .collect(Collectors.joining(
                        ", ")));

        return productService.findByCategoriesFilteredCharacteristics(PageRequest.of(pageNumber, pageSize),
                categoriesId,
                filter
        );
    }

    /**
     * REST service endpoint
     * Save product
     *
     * @param productCreateRequest Object Product
     */
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void save(
            @Valid @RequestPart("product") final ProductCreateRequest productCreateRequest,
            @RequestPart("images")  final List<MultipartFile> images) {
        Product product = new Product();

        product.setBrand(productCreateRequest.getBrand());
        product.setCategories(productCreateRequest.getCategories());
        product.setPrice(productCreateRequest.getPrice());
        product.setQuantity(productCreateRequest.getQuantity());
        product.setNameModel(productCreateRequest.getNameModel());

        int iterator = 0;
        final String path = "/app/images/";
        final String name = product.getNameModel().replace(' ', '-');

        for (MultipartFile image : images) {
            String imageName = path + name + "-" + iterator++ + "-" + image.getOriginalFilename();
            System.out.println(imageName);
            try {
                image.transferTo(Paths.get(imageName));
            } catch (IOException e) {
                log.error(e.getMessage());
            }
            product.getImage().add(new Image(null, imageName));
        }

        productService.save(product);
    }

    /**
     * REST service endpoint
     * Update product
     *
     * @param product Object Product
     */
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping("/update")
    public void update(@RequestBody Product product) {
        productService.save(product);
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping("/update-list")
    public void update(@RequestBody List<Product> product) {
        productService.save(product);
    }

    /**
     * REST service endpoint
     * Delete product
     *
     * @param product Object Product
     */
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping("/delete")
    public void delete(@RequestBody Product product) {
        productService.delete(product);
    }

}
