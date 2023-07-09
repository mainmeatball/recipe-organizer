package com.sstep.recipe.manager.service.impl

import com.sstep.recipe.manager.dao.RecipeDao
import com.sstep.recipe.manager.entity.Recipe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class RecipeService @Autowired constructor(
    private val recipeDao: RecipeDao
) {

    open fun findAll(): List<Recipe> {
        return recipeDao.findAll()
    }

    open fun findById(id: Long): Recipe {
        return recipeDao.findById(id)
    }

    open fun save(recipe: Recipe): Recipe {
        return recipeDao.save(recipe)
    }

    open fun remove(id: Long) {
        recipeDao.remove(id)
    }
}