package com.faketri.market.infastructure.product.payload.rating.controller;

import com.faketri.market.infastructure.product.payload.rating.dto.RatingDto;
import com.faketri.market.infastructure.product.payload.rating.dto.RatingDtoResponse;
import com.faketri.market.infastructure.product.payload.rating.gateway.RatingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin({"http://localhost:8081", "http://192.168.1.106:8081/"})
@RequestMapping(value = "/api/rating", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Rating", description = "Operation with product")
public class RatingController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final RatingService ratingService;


    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public Page<RatingDtoResponse> getRatingByProductId(@PathVariable UUID productId,
                                                        @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(name = "size", defaultValue = "20") Integer size) {
        return ratingService
                .findByIdProduct(productId, PageRequest.of(page, size))
                .map(rating -> new RatingDtoResponse(
                        rating.getId(),
                        rating.getDescription(),
                        rating.getGrade(),
                        rating.getUsers().getProfileImage(),
                        rating.getUsers().getLogin())
                );
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.POST)
    public RatingDtoResponse save(@RequestBody RatingDto ratingDto, @PathVariable("productId") UUID productId) {
        return ratingService.create(ratingDto, productId);
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@RequestParam("id") UUID uuid) {
        ratingService.deleteById(uuid);
    }
}
