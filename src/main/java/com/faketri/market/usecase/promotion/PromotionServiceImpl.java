package com.faketri.market.usecase.promotion;

import com.faketri.market.entity.exception.ResourceNotFoundException;
import com.faketri.market.entity.promotion.gateway.PromotionRepository;
import com.faketri.market.entity.promotion.model.Promotion;
import com.faketri.market.infastructure.promotion.gateway.PromotionService;
import com.faketri.market.usecase.product.ProductServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * The type Promotion service.
 *
 * @author Dmitriy Faketri
 */
@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionImpl;
    private final ProductServiceImpl productService;

    public PromotionServiceImpl(PromotionRepository promotionImpl, ProductServiceImpl productService) {
        this.promotionImpl = promotionImpl;
        this.productService = productService;
    }

    /**
     * Find by id promotion.
     *
     * @param id the id
     * @return the promotion
     */
    public Promotion findById(UUID id) {
        return promotionImpl.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Promotion with id - " + id + " not found"));
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Promotion> findAll() {
        return promotionImpl.findAll();
    }

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    public Page<Promotion> findAll(Pageable pageable) {
        return promotionImpl.findAll(pageable);
    }

    /**
     * Is promotion active.
     *
     * @param promotion the promotion
     */
    public void isPromotionActive(Promotion promotion) {
    }

    /**
     * Save promotion.
     *
     * @param promotion the promotion
     * @return the promotion
     */
    public Promotion save(Promotion promotion) {
        isPromotionActive(promotion);
        return promotionImpl.save(promotion);
    }

}
