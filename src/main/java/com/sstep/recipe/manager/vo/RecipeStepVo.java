package com.sstep.recipe.manager.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class RecipeStepVo {

    private Long recipeId;
    private String description;
    private Integer order;

    @JsonCreator
    public RecipeStepVo(
            @JsonProperty final Long recipeId,
            @JsonProperty final String description,
            @JsonProperty final Integer order) {
        this.recipeId = recipeId;
        this.description = description;
        this.order = order;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public String getDescription() {
        return description;
    }

    public Integer getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "RecipeStepVo{" +
                "recipeId=" + recipeId +
                ", description='" + description + '\'' +
                ", order=" + order +
                '}';
    }
}
