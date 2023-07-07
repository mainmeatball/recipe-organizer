package com.sstep.recipe.manager.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sstep.recipe.manager.enums.UnitOfMeasure;


public class IngredientVo {
    private String name;
    private UnitOfMeasure unitOfMeasure;
    private Double quantity;

    @JsonCreator
    public IngredientVo(
            @JsonProperty("name") final String name,
            @JsonProperty("unitOfMeasure") final UnitOfMeasure unitOfMeasure,
            @JsonProperty("quantity") final Double quantity) {
        this.name = name;
        this.unitOfMeasure = unitOfMeasure;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(final UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(final Double quantity) {
        this.quantity = quantity;
    }
}
