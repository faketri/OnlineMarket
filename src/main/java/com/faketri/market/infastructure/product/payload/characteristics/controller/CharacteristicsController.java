package com.faketri.market.infastructure.product.payload.characteristics.controller;

import com.faketri.market.entity.product.payload.characteristics.model.Characteristics;
import com.faketri.market.infastructure.product.payload.characteristics.gateway.CharacteristicsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * The type Characteristics controller.
 *
 * @author Dmitriy Faketri
 */
@RestController()
@CrossOrigin({"http://localhost:8081", "http://192.168.1.106:8081/"})
@RequestMapping(path = "/api/characteristics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Characteristics", description = "")
public class CharacteristicsController {

    private final CharacteristicsService characteristicsService;

    @Autowired
    public CharacteristicsController(CharacteristicsService characteristicsService) {
        this.characteristicsService = characteristicsService;
    }

    @RequestMapping("/product/{categoryId}")
    public List<Characteristics> findCharacteristicsByProductCategory(
            @PathVariable(name = "categoryId") UUID categoryId
    ) {
        return characteristicsService.findCharacteristicsByProductCategory(
                categoryId);
    }

    @RequestMapping("/")
    public List<Characteristics> findAll() {
        return characteristicsService.findAll();
    }

}
