package com.faketri.market.infastructure.product.payload.characteristics.gateway;

import com.faketri.market.entity.product.payload.characteristics.model.Characteristics;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CharacteristicsService {

    List<Characteristics> findAll();

    List<Characteristics> findCharacteristicsByProductCategory(UUID categoryId);

    Optional<Characteristics> findByNameAndValue(String name, String value);

    Characteristics save(Characteristics characteristics);

}
