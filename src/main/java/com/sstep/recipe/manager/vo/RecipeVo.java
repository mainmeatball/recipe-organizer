package com.sstep.recipe.manager.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sstep.recipe.manager.enums.RecipeType;

import java.util.Collections;
import java.util.List;


public class RecipeVo {

    private final Long id;
    private final String name;
    private final String description;
    private final RecipeType recipeType;
    private final List<IngredientVo> ingredients;
    private final List<RecipeStepVo> steps;

    @JsonCreator
    public RecipeVo(
            @JsonProperty final Long id,
            @JsonProperty final String name,
            @JsonProperty final String description,
            @JsonProperty final RecipeType recipeType,
            @JsonProperty final List<IngredientVo> ingredients,
            @JsonProperty final List<RecipeStepVo> steps) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.recipeType = recipeType;
        this.ingredients = ingredients == null ? Collections.emptyList() : ingredients;
        this.steps = steps == null ? Collections.emptyList() : steps;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public RecipeType getRecipeType() {
        return recipeType;
    }

    public List<IngredientVo> getIngredients() {
        return ingredients;
    }

    public List<RecipeStepVo> getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "RecipeVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", recipeType=" + recipeType +
                ", ingredients=" + ingredients +
                ", steps=" + steps +
                '}';
    }
}