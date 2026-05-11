package com.example.aem.services.impl;

import com.example.aem.models.Recipe;
import com.example.aem.services.RecipeService;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementation of RecipeService
 * This is a sample implementation using in-memory storage.
 * In production, this would be backed by JCR or a database.
 */
@Component(
    service = RecipeService.class,
    immediate = true
)
public class RecipeServiceImpl implements RecipeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeServiceImpl.class);
    private Map<String, Recipe> recipeStore;

    @Activate
    protected void activate() {
        LOGGER.info("Activating Recipe Service");
        recipeStore = new HashMap<>();
        initializeSampleData();
    }

    /**
     * Initialize with sample recipe data
     */
    private void initializeSampleData() {
        // Sample Recipe 1: Pasta Carbonara
        Recipe recipe1 = new Recipe();
        recipe1.setId("recipe-001");
        recipe1.setRecipeName("Pasta Carbonara");
        recipe1.setDescription("Classic Italian pasta dish made with eggs, guanciale, and pecorino cheese");
        recipe1.setCuisineType("Italian");
        recipe1.setPrepTime(15);
        recipe1.setCookTime(20);
        recipe1.setServings(4);
        recipe1.setDifficultyLevel("Easy");
        recipe1.setRating(4.8);
        recipe1.setAuthor("Italian Chef");
        recipe1.setFeatured(true);
        recipe1.getIngredientsList().addAll(Arrays.asList(
            "400g Spaghetti",
            "200g Guanciale",
            "100g Pecorino Romano",
            "4 Large Eggs",
            "Black Pepper to taste",
            "Salt to taste"
        ));
        recipe1.getInstructionsList().addAll(Arrays.asList(
            "Bring a large pot of salted water to boil",
            "Cook spaghetti until al dente",
            "While pasta cooks, fry guanciale until crispy",
            "Beat eggs with grated pecorino",
            "Combine pasta with guanciale and fat",
            "Off heat, add egg mixture and toss quickly",
            "Serve with black pepper and extra cheese"
        ));
        recipeStore.put(recipe1.getId(), recipe1);

        // Sample Recipe 2: Butter Chicken
        Recipe recipe2 = new Recipe();
        recipe2.setId("recipe-002");
        recipe2.setRecipeName("Butter Chicken");
        recipe2.setDescription("Creamy and aromatic Indian curry with tender chicken");
        recipe2.setCuisineType("Indian");
        recipe2.setPrepTime(30);
        recipe2.setCookTime(40);
        recipe2.setServings(6);
        recipe2.setDifficultyLevel("Medium");
        recipe2.setRating(4.6);
        recipe2.setAuthor("Indian Chef");
        recipe2.setFeatured(true);
        recipe2.getIngredientsList().addAll(Arrays.asList(
            "1kg Chicken Breast",
            "200ml Yogurt",
            "100g Butter",
            "400ml Tomato Puree",
            "200ml Cream",
            "Ginger-Garlic Paste",
            "Spices (Garam Masala, Chili, Cumin)"
        ));
        recipe2.getInstructionsList().addAll(Arrays.asList(
            "Marinate chicken in yogurt and spices for 30 minutes",
            "Grill or broil chicken until cooked",
            "Heat butter in a pan",
            "Add ginger-garlic paste and cook",
            "Add tomato puree and simmer",
            "Add cream and cooked chicken",
            "Simmer for 10 minutes and serve"
        ));
        recipeStore.put(recipe2.getId(), recipe2);

        LOGGER.info("Initialized {} sample recipes", recipeStore.size());
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return new ArrayList<>(recipeStore.values());
    }

    @Override
    public List<Recipe> getRecipesByCuisine(String cuisineType) {
        return recipeStore.values().stream()
            .filter(r -> cuisineType.equalsIgnoreCase(r.getCuisineType()))
            .collect(Collectors.toList());
    }

    @Override
    public List<Recipe> getRecipesByDifficulty(String difficultyLevel) {
        return recipeStore.values().stream()
            .filter(r -> difficultyLevel.equalsIgnoreCase(r.getDifficultyLevel()))
            .collect(Collectors.toList());
    }

    @Override
    public Recipe getRecipeByName(String recipeName) {
        return recipeStore.values().stream()
            .filter(r -> r.getRecipeName().equalsIgnoreCase(recipeName))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<Recipe> searchRecipes(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return recipeStore.values().stream()
            .filter(r -> r.getRecipeName().toLowerCase().contains(lowerKeyword) ||
                        r.getDescription().toLowerCase().contains(lowerKeyword) ||
                        r.getCuisineType().toLowerCase().contains(lowerKeyword))
            .collect(Collectors.toList());
    }

    @Override
    public List<Recipe> getFeaturedRecipes() {
        return recipeStore.values().stream()
            .filter(r -> Boolean.TRUE.equals(r.getFeatured()))
            .collect(Collectors.toList());
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        if (recipe.getId() == null || recipe.getId().isEmpty()) {
            recipe.setId("recipe-" + System.currentTimeMillis());
        }
        recipeStore.put(recipe.getId(), recipe);
        LOGGER.info("Created recipe: {}", recipe.getRecipeName());
        return recipe;
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        if (recipeStore.containsKey(recipe.getId())) {
            recipeStore.put(recipe.getId(), recipe);
            LOGGER.info("Updated recipe: {}", recipe.getRecipeName());
            return recipe;
        }
        LOGGER.warn("Recipe not found for update: {}", recipe.getId());
        return null;
    }

    @Override
    public boolean deleteRecipe(String recipeId) {
        if (recipeStore.containsKey(recipeId)) {
            recipeStore.remove(recipeId);
            LOGGER.info("Deleted recipe: {}", recipeId);
            return true;
        }
        LOGGER.warn("Recipe not found for deletion: {}", recipeId);
        return false;
    }

    @Override
    public Recipe getRecipeById(String recipeId) {
        return recipeStore.get(recipeId);
    }
}
