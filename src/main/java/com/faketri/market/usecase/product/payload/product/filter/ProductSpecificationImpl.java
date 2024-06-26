package com.faketri.market.usecase.product.payload.product.filter;

import com.faketri.market.entity.product.payload.brand.model.Brand;
import com.faketri.market.entity.product.payload.categories.model.Categories;
import com.faketri.market.entity.product.payload.characteristics.model.Characteristics;
import com.faketri.market.entity.product.payload.product.model.Product;
import com.faketri.market.infastructure.product.payload.product.gateway.filter.ProductSpecification;
import com.faketri.market.usecase.product.payload.product.ProductServiceImpl;
import jakarta.persistence.criteria.Join;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductSpecificationImpl implements ProductSpecification {
    static final Logger log = LoggerFactory.getLogger(ProductSpecificationImpl.class);

    @Override
    public Specification<Product> hasId(List<UUID> UUID) {
        return (root, query, criteriaBuilder) -> root.get("id").in(UUID);
    }

    public Specification<Product> hasCharacteristics(
            Characteristics characteristics
    ) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.join("characteristics").get("id"), characteristics.getId()
                );
    }

    public Specification<Product> hasCharacteristics(
            UUID characteristics
    ) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.join("characteristics").get("id"), characteristics
                );
    }

    public Specification<Product> hasCharacteristics(
            List<Characteristics> characteristics
    ) {
        return (root, query, criteriaBuilder) ->
                root.join("characteristics")
                        .get("id")
                        .in(characteristics.stream()
                                .map(Characteristics::getId)
                                .toList());
    }

    public Specification<Product> hasCharacteristicsByUUID(
            List<UUID> characteristics
    ) {
        return (root, query, criteriaBuilder) ->
                root.join("characteristics")
                        .get("id")
                        .in(characteristics.stream()
                                .toList());
    }

    public Specification<Product> hasCategories(UUID categoriesId) {
        return (root, query, criteriaBuilder) -> {
            Join<Categories, Product> productCategories =
                    root.join("categories");
            return criteriaBuilder.equal(productCategories.get("id"),
                    categoriesId
            );
        };
    }

    public Specification<Product> likeByNameModelOrBrandName(String name) {
        return (root, query, criteriaBuilder) -> {
            Join<Brand, Product> brandProductJoin = root.join("brand");
            final String likeName = "%" + name.toLowerCase().trim() + "%";
            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("nameModel")), likeName),
                    criteriaBuilder.like(criteriaBuilder.lower(brandProductJoin.get("name")), likeName)
            );
        };
    }

    public Specification<Product> isPromoItem() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isPromoItem"), true);
    }

    public Specification<Product> priceBetween(Integer minPrice, Integer maxPrice) {
        log.info("priceBetween: " + minPrice + ", " + maxPrice);
        return (root, query, criteriaBuilder) -> {
            if (minPrice != null && maxPrice != null) {
                return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
            } else if (minPrice != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            } else if (maxPrice != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            } else {
                return criteriaBuilder.conjunction();
            }
        };
    }
}
