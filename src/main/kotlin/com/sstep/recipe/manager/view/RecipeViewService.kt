package com.sstep.recipe.manager.view

import com.sstep.recipe.manager.dto.RecipeData
import com.sstep.recipe.manager.entity.Recipe
import com.sstep.recipe.manager.service.impl.RecipeService
import com.sstep.recipe.manager.vo.RecipeVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
open class RecipeViewService @Autowired constructor(
    private val recipeService: RecipeService
) {

    open fun findAll(): List<RecipeVo> {
        val recipes = recipeService.findAll()
        return recipes.map { it.toVo() }
    }

    open fun findById(id: Long): RecipeVo {
        val recipe = recipeService.findById(id)
        return recipe.toVo()
    }

    @Transactional(propagation = Propagation.REQUIRED)
    open fun save(recipeVo: RecipeVo): RecipeVo {
        val recipe: Recipe
        if (recipeVo.id != null) {
            recipe = recipeService.findById(recipeVo.id)
            recipe.apply {
                name = recipeVo.name
                description = recipeVo.description
                recipeType = recipeVo.recipeType
                recipeData = RecipeData(recipeVo)
                previewId = recipeVo.recipePreviewId
            }
        } else {
            recipe = recipeVo.toEntity()
        }
        val savedRecipe = recipeService.save(recipe)
        return savedRecipe.toVo()
    }

    @Transactional(propagation = Propagation.REQUIRED)
    open fun remove(id: Long) {
        recipeService.remove(id)
    }

    private fun RecipeVo.toEntity() = Recipe().apply {
        id = this@toEntity.id
        name = this@toEntity.name
        description = this@toEntity.description
        recipeType = this@toEntity.recipeType
        recipeData = RecipeData(this@toEntity)
    }

    private fun Recipe.toVo(): RecipeVo {
        return RecipeVo(
            id = id,
            name = name,
            description = description,
            recipeType = recipeType,
            recipePreviewId = previewId,
            ingredients = recipeData?.ingredients ?: emptyList(),
            steps = recipeData?.steps ?: emptyList()
        )
    }
}