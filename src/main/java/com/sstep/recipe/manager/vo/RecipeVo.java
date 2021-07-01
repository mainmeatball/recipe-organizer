package com.sstep.recipe.manager.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sstep.recipe.manager.enums.RecipeType;

import java.util.Collections;
import java.util.List;


public class RecipeVo {

    private Long id;
    private String name;
    private String description;
    private RecipeType recipeType;
    private List<RecipeStepVo> recipeSteps;

    @JsonCreator
    public RecipeVo(
            @JsonProperty final Long id,
            @JsonProperty final String name,
            @JsonProperty final String description,
            @JsonProperty final RecipeType recipeType,
            @JsonProperty final List<RecipeStepVo> recipeSteps) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.recipeType = recipeType;
        this.recipeSteps = recipeSteps == null ? Collections.emptyList() : recipeSteps;
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

    public List<RecipeStepVo> getRecipeSteps() {
        return recipeSteps;
    }

    @Override
    public String toString() {
        return "RecipeVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", recipeType=" + recipeType +
                ", recipeSteps=" + recipeSteps +
                '}';
    }
}