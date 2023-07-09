package com.sstep.recipe.manager.vo

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.sstep.recipe.manager.enums.RecipeType

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class RecipeVo @JsonCreator constructor(
    val id: Long? = null,
    val name: String? = null,
    val description: String? = null,
    val recipeType: RecipeType? = null,
    val recipePreviewId: String? = null,
    val ingredients: List<IngredientVo> = emptyList(),
    val steps: List<RecipeStepVo> = emptyList()
)