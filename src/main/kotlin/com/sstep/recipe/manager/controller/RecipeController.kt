package com.sstep.recipe.manager.controller

import com.sstep.recipe.manager.view.RecipeViewService
import com.sstep.recipe.manager.vo.RecipeVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
open class RecipeController @Autowired constructor(
    private val recipeViewService: RecipeViewService
) {

    @PostMapping("/recipes")
    open fun saveRecipe(@RequestBody recipeVo: RecipeVo): RecipeVo {
        return recipeViewService.save(recipeVo)
    }

    @GetMapping(value = ["/recipes"])
    open fun getRecipes(): List<RecipeVo> {
        return recipeViewService.findAll()
    }

    @DeleteMapping(value = ["/recipe"])
    open fun deleteRecipe(@RequestParam("id") id: Long) {
        recipeViewService.remove(id)
    }

    @GetMapping(value = ["/recipe"])
    @ResponseBody
    open fun getRecipe(@RequestParam("id") id: Long): RecipeVo {
        return recipeViewService.findById(id)
    }
}