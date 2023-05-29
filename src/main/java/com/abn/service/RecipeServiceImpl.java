package com.abn.service;

import com.abn.model.Recipe;
import com.abn.exception.RecipeNotFoundException;
import com.abn.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    @Override
    public Recipe getRecipeById(Long id) throws RecipeNotFoundException {
        return recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));
    }
    @Override
    @Transactional
    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.saveAndFlush(recipe);
    }
    @Override
    @Transactional
    public Recipe updateRecipe(Long id, Recipe updatedRecipe) throws RecipeNotFoundException {
        Recipe recipe = getRecipeById(id);
        recipe.setName(updatedRecipe.getName());
        recipe.setInstruction(updatedRecipe.getInstruction());
        recipe.setServing(updatedRecipe.getServing());
        recipe.setVegetarian(updatedRecipe.isVegetarian());
        recipe.setIngredient(updatedRecipe.getIngredient());
        return recipeRepository.saveAndFlush(recipe);
    }
    @Override
    @Transactional
    public Recipe deleteRecipe(Long id) throws RecipeNotFoundException {
        Recipe recipe = getRecipeById(id);
        recipeRepository.delete(recipe);
        return recipe;
    }
    @Override
    public List<Recipe> getVegetarianRecipes() {
        return recipeRepository.findByVegetarian(true);
    }
    @Override
    public List<Recipe> getRecipesByServings(int servings) {
        return recipeRepository.findByServings(servings);
    }
    @Override
    public List<Recipe> getRecipesByIngredient(String ingredient) {
        return recipeRepository.findByIngredientsContaining(ingredient);
    }
    @Override
    public List<Recipe> getRecipesWithoutIngredient(String ingredient) {
        return recipeRepository.findByIngredientsNotContaining(ingredient);
    }
    @Override
    public List<Recipe> searchRecipesByKeyword(String keyword) {
        return recipeRepository.findByInstructionsContaining(keyword);
    }
}
