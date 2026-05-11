package com.example.aem.components;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Sling Model for Recipe Component
 */
@Model(adaptables = Resource.class)
public class RecipeComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeComponent.class);

    @ValueMapValue
    @Optional
    private String recipeName;

    @ValueMapValue
    @Optional
    private String description;

    @ValueMapValue
    @Default(values = "Italian")
    private String cuisineType;

    @ValueMapValue
    @Optional
    private Integer prepTime;

    @ValueMapValue
    @Optional
    private Integer cookTime;

    @ValueMapValue
    @Optional
    private Integer servings;

    @ValueMapValue
    @Default(values = "Easy")
    private String difficultyLevel;

    @ValueMapValue
    @Optional
    private Double rating;

    @ValueMapValue
    @Optional
    private String recipeImage;

    @ValueMapValue
    @Optional
    private String[] ingredients;

    @ValueMapValue
    @Optional
    private String[] instructions;

    // Getters
    public String getRecipeName() {
        return recipeName;
    }

    public String getDescription() {
        return description;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public Integer getPrepTime() {
        return prepTime != null ? prepTime : 0;
    }

    public Integer getCookTime() {
        return cookTime != null ? cookTime : 0;
    }

    public Integer getTotalTime() {
        return getPrepTime() + getCookTime();
    }

    public Integer getServings() {
        return servings != null ? servings : 4;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public Double getRating() {
        return rating != null ? rating : 0.0;
    }

    public String getRecipeImage() {
        return recipeImage;
    }

    public List<String> getIngredients() {
        return ingredients != null ? Arrays.asList(ingredients) : Arrays.asList();
    }

    public List<String> getInstructions() {
        return instructions != null ? Arrays.asList(instructions) : Arrays.asList();
    }

    public int getIngredientsCount() {
        return getIngredients().size();
    }

    public int getInstructionsCount() {
        return getInstructions().size();
    }

    public String getDifficultyBadgeClass() {
        switch (difficultyLevel) {
            case "Easy":
                return "badge-success";
            case "Medium":
                return "badge-warning";
            case "Hard":
                return "badge-danger";
            default:
                return "badge-secondary";
        }
    }

    public String getCuisineIcon() {
        switch (cuisineType) {
            case "Italian":
                return "🇮🇹";
            case "Indian":
                return "🇮🇳";
            case "Mexican":
                return "🇲🇽";
            case "Chinese":
                return "🇨🇳";
            case "French":
                return "🇫🇷";
            default:
                return "🍽️";
        }
    }
}
