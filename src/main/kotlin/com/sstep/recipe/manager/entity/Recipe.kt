package com.sstep.recipe.manager.entity

import com.sstep.recipe.manager.dto.RecipeData
import com.sstep.recipe.manager.enums.RecipeType
import jakarta.persistence.*

@Entity
@Table(name = "recipe")
class Recipe {

    @get:Id
    @get:Column(name = "id")
    @get:Basic
    @get:GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_seq_gen")
    @get:SequenceGenerator(name = "recipe_seq_gen", sequenceName = "recipe_seq", allocationSize = 1)
    var id: Long? = null

    @get:Basic
    @get:Column(name = "name", nullable = false)
    var name: String? = null

    @get:Basic
    @get:Column(name = "description")
    var description: String? = null

    @get:Basic
    @get:Column(name = "type", nullable = false)
    var recipeType: RecipeType? = null

    @get:Column(name = "data")
    var recipeData: RecipeData? = null

    @get:Basic
    @get:Column(name = "preview_id")
    var previewId: String? = null
}