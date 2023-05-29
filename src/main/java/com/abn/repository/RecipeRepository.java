package com.abn.repository;

import com.abn.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r From Recipe r WHERE r.vegetarian = :vegetarian")
    List<Recipe> findByVegetarian(@Param("vegetarian") boolean vegetarian);
    @Query("SELECT r From Recipe r WHERE r.serving = :servings")
    List<Recipe> findByServings(@Param("serving") int servings);
    @Query("SELECT r From Recipe r WHERE r.ingredient LIKE '%:ingredient%' ")
    List<Recipe> findByIngredientsContaining(@Param("ingredient") String ingredient);
    @Query("SELECT r From Recipe r WHERE r.ingredient NOT LIKE '%:ingredient%' ")
    List<Recipe> findByIngredientsNotContaining(@Param("ingredient") String ingredient);
    @Query("SELECT r From Recipe r WHERE r.instruction LIKE '%:ingredient%' ")
    List<Recipe> findByInstructionsContaining(@Param("keyword") String keyword);
}

