package com.abn.service;

import com.abn.exception.RecipeNotFoundException;
import com.abn.model.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getAllRecipes();

    Recipe getRecipeById(Long id) throws RecipeNotFoundException;

    Recipe addRecipe(Recipe recipe);

    Recipe updateRecipe(Long id, Recipe updatedRecipe) throws RecipeNotFoundException;

    Recipe deleteRecipe(Long id) throws RecipeNotFoundException;

    List<Recipe> getVegetarianRecipes();

    List<Recipe> getRecipesByServings(int servings);

    List<Recipe> getRecipesByIngredient(String ingredient);

    List<Recipe> getRecipesWithoutIngredient(String ingredient);

    List<Recipe> searchRecipesByKeyword(String keyword);
}
