package com.sstep.recipe.manager.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sstep.recipe.manager.enums.IngredientType;


public class IngredientVo {
    private String name;
    private IngredientType type;
    private Double quantity;

    @JsonCreator
    public IngredientVo(
            @JsonProperty("name") final String name,
            @JsonProperty("type") final IngredientType type,
            @JsonProperty("quantity") final Double quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public IngredientType getType() {
        return type;
    }

    public void setType(final IngredientType type) {
        this.type = type;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(final Double quantity) {
        this.quantity = quantity;
    }
}
