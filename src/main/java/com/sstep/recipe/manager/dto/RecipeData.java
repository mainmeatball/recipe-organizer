package com.sstep.recipe.manager.dto;

import com.sstep.recipe.manager.vo.IngredientVo;
import com.sstep.recipe.manager.vo.RecipeStepVo;
import com.sstep.recipe.manager.vo.RecipeVo;

import java.util.List;


public record RecipeData(
        List<IngredientVo> ingredients,
        List<RecipeStepVo> steps
) {

    public RecipeData() {
        this(List.of(), List.of());
    }

    public RecipeData(final RecipeVo recipeVo) {
        this(recipeVo.getIngredients(), recipeVo.getSteps());
    }
}