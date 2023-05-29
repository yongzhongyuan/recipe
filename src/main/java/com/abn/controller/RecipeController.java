package com.abn.controller;

import com.abn.model.Recipe;
import com.abn.exception.RecipeNotFoundException;
import com.abn.service.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeServiceImpl recipeServiceImpl;

    @Autowired
    public RecipeController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Recipe> getAllRecipes() {
        return recipeServiceImpl.getAllRecipes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Recipe getRecipeById(@PathVariable Long id) throws RecipeNotFoundException {
        return recipeServiceImpl.getRecipeById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeServiceImpl.addRecipe(recipe);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Recipe deleteRecipeById(@PathVariable Long id) throws RecipeNotFoundException {
        return recipeServiceImpl.deleteRecipe(id);
    }
}

