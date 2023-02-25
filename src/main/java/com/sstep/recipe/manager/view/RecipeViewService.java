package com.sstep.recipe.manager.view;


import com.sstep.recipe.manager.dto.RecipeData;
import com.sstep.recipe.manager.entity.Recipe;
import com.sstep.recipe.manager.service.RecipeService;
import com.sstep.recipe.manager.vo.RecipeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RecipeViewService {

    private final RecipeService recipeService;

    @Autowired
    public RecipeViewService(final RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    public List<RecipeVo> findAll() {
        final List<Recipe> recipes = recipeService.findAll();
        return recipes.stream().map(this::toVo).collect(Collectors.toList());
    }

    public RecipeVo findById(final long id) {
        final Recipe recipe = recipeService.findById(id);
        return toVo(recipe);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public RecipeVo save(final RecipeVo recipeVo) {
        final Recipe recipe;
        if (recipeVo.getId() != null) {
            recipe = recipeService.findById(recipeVo.getId());
            recipe.setName(recipeVo.getName());
            recipe.setDescription(recipeVo.getDescription());
            recipe.setRecipeType(recipeVo.getRecipeType());
            recipe.setRecipeData(new RecipeData(recipeVo));
        } else {
            recipe = toEntity(recipeVo);
        }
        final Recipe savedRecipe = recipeService.save(recipe);
        return toVo(savedRecipe);
    }

    private Recipe toEntity(final RecipeVo recipeVo) {
        final Recipe recipe = new Recipe();
        recipe.setId(recipeVo.getId());
        recipe.setName(recipeVo.getName());
        recipe.setDescription(recipeVo.getDescription());
        recipe.setRecipeType(recipeVo.getRecipeType());

        final RecipeData recipeData = new RecipeData(recipeVo);
        recipe.setRecipeData(recipeData);

        return recipe;
    }

    private RecipeVo toVo(final Recipe recipe) {
        return new RecipeVo(
                recipe.getId(),
                recipe.getName(),
                recipe.getDescription(),
                recipe.getRecipeType(),
                recipe.getRecipeData().ingredients(),
                recipe.getRecipeData().steps()
        );
    }
}
