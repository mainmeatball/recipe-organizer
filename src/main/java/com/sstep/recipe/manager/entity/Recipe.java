package com.sstep.recipe.manager.entity;

import com.sstep.recipe.manager.enums.RecipeType;


public class Recipe {

    private Long id;
    private String name;
    private String description;
    private RecipeType recipeType;

    public Recipe(final Long id, final String name, final String description, final RecipeType recipeType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.recipeType = recipeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public RecipeType getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(final RecipeType recipeType) {
        this.recipeType = recipeType;
    }
}
