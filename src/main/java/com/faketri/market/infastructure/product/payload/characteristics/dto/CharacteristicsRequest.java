package com.faketri.market.infastructure.product.payload.characteristics.dto;

/**
 * The type Characteristics request.
 *
 * @author Dmitriy Faketri
 */
public class CharacteristicsRequest {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
