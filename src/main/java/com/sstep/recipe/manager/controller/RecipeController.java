package com.sstep.recipe.manager.controller;


import com.sstep.recipe.manager.entity.Recipe;
import com.sstep.recipe.manager.enums.RecipeType;
import com.sstep.recipe.manager.vo.RecipeStepVo;
import com.sstep.recipe.manager.vo.RecipeVo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
public class RecipeController {

    @PostMapping("/recipes/new")
    public String saveRecipe(@RequestBody final RecipeVo recipe) {
        System.out.println(recipe);
        return "hello";
    }

    @GetMapping(value = "/recipes")
    public List<RecipeVo> getAllRecipes() {
        final RecipeVo r1 = new RecipeVo(1L, "Recipe1", "Description1", RecipeType.MAIN,
                List.of(
                        new RecipeStepVo(1L, "descr1", 10),
                        new RecipeStepVo(1L, "descr2", 20),
                        new RecipeStepVo(1L, "descr3", 30)
                )
        );
        final RecipeVo r2 = new RecipeVo(2L, "Recipe2", "Description2", RecipeType.BEVERAGE,
                List.of(
                        new RecipeStepVo(2L, "descr1", 10)
                )
        );
        final RecipeVo r3 = new RecipeVo(3L, "Recipe3", "Description3", RecipeType.SOUP, Collections.emptyList());
        return List.of(r1, r2, r3);
    }
}
