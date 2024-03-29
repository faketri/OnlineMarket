package com.faketri.market.infastructure.productPayload.product.gateway.filter;

import com.faketri.market.entity.productPayload.characteristics.model.Characteristics;
import com.faketri.market.entity.productPayload.product.model.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ProductSpecification {

    Specification<Product> hasCharacteristics(Characteristics characteristics);

    Specification<Product> hasCharacteristics(List<Characteristics> characteristics);

    Specification<Product> hasCategories(UUID categoriesId);

    Specification<Product> likeNameAndBrand(String name, String brandName);

    Specification<Product> isPromoItem();

}
