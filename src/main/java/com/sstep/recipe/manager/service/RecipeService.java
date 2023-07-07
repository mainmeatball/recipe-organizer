package com.sstep.recipe.manager.service;


import com.sstep.recipe.manager.dao.RecipeDao;
import com.sstep.recipe.manager.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecipeService {

    private final RecipeDao recipeDao;

    @Autowired
    public RecipeService(final RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public List<Recipe> findAll() {
        return recipeDao.findAll();
    }

    public Recipe findById(final long id) {
        return recipeDao.findById(id);
    }

    public Recipe save(final Recipe recipe) {
        return recipeDao.save(recipe);
    }

    public void remove(final long id) { recipeDao.remove(id);}
}
