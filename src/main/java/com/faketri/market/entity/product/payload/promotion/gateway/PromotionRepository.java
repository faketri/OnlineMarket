package com.faketri.market.entity.product.payload.promotion.gateway;

import com.faketri.market.entity.product.payload.promotion.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The interface Promotion repository.
 *
 * @author Dmitriy Faketri
 */
public interface PromotionRepository extends JpaRepository<Promotion, UUID> {

    Optional<Promotion> findById(UUID aLong);

    @Override
    List<Promotion> findAll();

    @Override
    void deleteById(UUID aLong);


}