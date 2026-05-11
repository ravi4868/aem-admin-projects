package com.example.aem.services;

import com.example.aem.models.Recipe;
import com.example.aem.services.impl.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests for RecipeService
 */
public class RecipeServiceImplTest {

    private RecipeService recipeService;

    @Before
    public void setUp() {
        RecipeServiceImpl service = new RecipeServiceImpl();
        service.activate();
        recipeService = service;
    }

    @Test
    public void testGetAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        assertNotNull(recipes);
        assertTrue(recipes.size() > 0);
    }

    @Test
    public void testGetRecipesByCuisine() {
        List<Recipe> italianRecipes = recipeService.getRecipesByCuisine("Italian");
        assertNotNull(italianRecipes);
        assertTrue(italianRecipes.size() > 0);
        
        for (Recipe recipe : italianRecipes) {
            assertEquals("Italian", recipe.getCuisineType());
        }
    }

    @Test
    public void testGetFeaturedRecipes() {
        List<Recipe> featured = recipeService.getFeaturedRecipes();
        assertNotNull(featured);
        
        for (Recipe recipe : featured) {
            assertTrue(recipe.getFeatured());
        }
    }

    @Test
    public void testCreateRecipe() {
        Recipe newRecipe = new Recipe();
        newRecipe.setRecipeName("Test Recipe");
        newRecipe.setCuisineType("Test");
        newRecipe.setDifficultyLevel("Easy");
        
        Recipe created = recipeService.createRecipe(newRecipe);
        assertNotNull(created);
        assertNotNull(created.getId());
        
        Recipe retrieved = recipeService.getRecipeById(created.getId());
        assertNotNull(retrieved);
        assertEquals("Test Recipe", retrieved.getRecipeName());
    }

    @Test
    public void testSearchRecipes() {
        List<Recipe> results = recipeService.searchRecipes("pasta");
        assertNotNull(results);
        
        for (Recipe recipe : results) {
            assertTrue(
                recipe.getRecipeName().toLowerCase().contains("pasta") ||
                recipe.getDescription().toLowerCase().contains("pasta")
            );
        }
    }

    @Test
    public void testGetRecipeByName() {
        Recipe recipe = recipeService.getRecipeByName("Pasta Carbonara");
        assertNotNull(recipe);
        assertEquals("Pasta Carbonara", recipe.getRecipeName());
    }
}
