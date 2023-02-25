package com.sstep.recipe.manager.dao;


import com.sstep.recipe.manager.entity.Recipe;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class RecipeDao {

    @PersistenceContext
    private EntityManager em;

    public List<Recipe> findAll() {
        return em.createQuery("SELECT recipe FROM Recipe recipe", Recipe.class)
                .getResultList();
    }

    public Recipe findById(final long id) {
        return em.createQuery("SELECT recipe FROM Recipe recipe WHERE recipe.id = :id", Recipe.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public Recipe save(final Recipe recipe) {
        em.persist(recipe);
        return recipe;
    }
}
