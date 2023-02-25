package com.sstep.recipe.manager.entity;

import com.sstep.recipe.manager.dto.RecipeData;
import com.sstep.recipe.manager.enums.RecipeType;

import javax.persistence.*;


@Entity
@Table(name = "recipe")
public class Recipe {

    private Long id;
    private String name;
    private String description;
    private RecipeType recipeType;
    private RecipeData recipeData;

    public Recipe() {
    }

    @Basic
    @Column(name = "id")
    @Id
    @SequenceGenerator(name = "recipe_seq_gen", sequenceName = "recipe_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_seq_gen")
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public RecipeType getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(final RecipeType recipeType) {
        this.recipeType = recipeType;
    }

    @Column(name = "data")
    public RecipeData getRecipeData() {
        return recipeData;
    }

    public void setRecipeData(final RecipeData recipeData) {
        this.recipeData = recipeData;
    }
}
