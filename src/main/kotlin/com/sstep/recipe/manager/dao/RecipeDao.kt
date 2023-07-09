package com.sstep.recipe.manager.dao

import com.sstep.recipe.manager.entity.Recipe
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository

@Repository
open class RecipeDao {

    @PersistenceContext
    private lateinit var em: EntityManager

    open fun findAll(): List<Recipe> {
        return em.createQuery("SELECT recipe FROM Recipe recipe", Recipe::class.java)
            .resultList
    }

    open fun findById(id: Long): Recipe {
        return em.createQuery("SELECT recipe FROM Recipe recipe WHERE recipe.id = :id", Recipe::class.java)
            .setParameter("id", id)
            .singleResult
    }

    open fun save(recipe: Recipe): Recipe {
        em.persist(recipe)
        return recipe
    }

    open fun remove(id: Long) {
        val recipe = findById(id)
        em.remove(recipe)
    }
}