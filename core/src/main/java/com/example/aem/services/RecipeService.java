package com.example.aem.services;

import com.example.aem.models.Recipe;
import java.util.List;

/**
 * Service interface for Recipe management operations
 */
public interface RecipeService {

    /**
     * Get all recipes
     * @return List of all recipes
     */
    List<Recipe> getAllRecipes();

    /**
     * Get recipes by cuisine type
     * @param cuisineType The cuisine type to filter by
     * @return List of recipes matching the cuisine type
     */
    List<Recipe> getRecipesByCuisine(String cuisineType);

    /**
     * Get recipes by difficulty level
     * @param difficultyLevel The difficulty level (Easy, Medium, Hard)
     * @return List of recipes matching the difficulty level
     */
    List<Recipe> getRecipesByDifficulty(String difficultyLevel);

    /**
     * Get a specific recipe by name
     * @param recipeName The name of the recipe
     * @return The recipe object or null if not found
     */
    Recipe getRecipeByName(String recipeName);

    /**
     * Search recipes by keyword
     * @param keyword The search keyword
     * @return List of recipes matching the keyword
     */
    List<Recipe> searchRecipes(String keyword);

    /**
     * Get featured recipes
     * @return List of featured recipes
     */
    List<Recipe> getFeaturedRecipes();

    /**
     * Create a new recipe
     * @param recipe The recipe to create
     * @return The created recipe with generated ID
     */
    Recipe createRecipe(Recipe recipe);

    /**
     * Update an existing recipe
     * @param recipe The recipe to update
     * @return The updated recipe
     */
    Recipe updateRecipe(Recipe recipe);

    /**
     * Delete a recipe
     * @param recipeId The ID of the recipe to delete
     * @return true if deleted successfully, false otherwise
     */
    boolean deleteRecipe(String recipeId);

    /**
     * Get recipe by ID
     * @param recipeId The ID of the recipe
     * @return The recipe object or null if not found
     */
    Recipe getRecipeById(String recipeId);
}
