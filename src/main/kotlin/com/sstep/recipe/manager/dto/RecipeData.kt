package com.sstep.recipe.manager.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.sstep.recipe.manager.vo.IngredientVo
import com.sstep.recipe.manager.vo.RecipeStepVo
import com.sstep.recipe.manager.vo.RecipeVo

data class RecipeData @JsonCreator constructor(
    val ingredients: List<IngredientVo> = emptyList(),
    val steps: List<RecipeStepVo> = emptyList(),
) {
    constructor(recipeVo: RecipeVo) : this(recipeVo.ingredients, recipeVo.steps)
}