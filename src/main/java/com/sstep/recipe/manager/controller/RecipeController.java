package com.sstep.recipe.manager.controller;


import com.sstep.recipe.manager.view.RecipeViewService;
import com.sstep.recipe.manager.vo.RecipeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RecipeController {

    private final RecipeViewService recipeViewService;

    @Autowired
    public RecipeController(final RecipeViewService recipeViewService) {
        this.recipeViewService = recipeViewService;
    }

    @PostMapping("/recipes")
    public @ResponseBody RecipeVo saveRecipe(@RequestBody final RecipeVo recipeVo) {
        return recipeViewService.save(recipeVo);
    }

    @GetMapping(value = "/recipes")
    public @ResponseBody List<RecipeVo> getRecipes() {
        return recipeViewService.findAll();
    }

    @DeleteMapping(value = "/recipe")
    public void deleteRecipe(@RequestParam("id") final long id) {
        recipeViewService.remove(id);
    }

    @GetMapping(value = "/recipe")
    public @ResponseBody RecipeVo getRecipe(@RequestParam("id") final long id) {
        return recipeViewService.findById(id);
    }
}
