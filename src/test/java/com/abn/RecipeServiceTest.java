package com.abn;

import com.abn.model.Recipe;
import com.abn.repository.RecipeRepository;
import com.abn.service.RecipeService;
import com.abn.service.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeService recipeService = new RecipeServiceImpl();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllRecipes_ReturnsAllRecipes() {
        // Arrange
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe());
        recipes.add(new Recipe());
        when(recipeRepository.findAll()).thenReturn(recipes);

        // Act
        List<Recipe> result = recipeService.getAllRecipes();

        // Assert
        assertEquals(2, result.size());
        verify(recipeRepository, times(1)).findAll();
    }

}

