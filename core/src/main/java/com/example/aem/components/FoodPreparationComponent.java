package com.example.aem.components;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.Arrays;
import java.util.List;

/**
 * Sling Model for Food Preparation Component
 */
@Model(adaptables = Resource.class)
public class FoodPreparationComponent {

    @ValueMapValue
    @Optional
    private String preparationTitle;

    @ValueMapValue
    @Default(values = "Vegetables")
    private String foodCategory;

    @ValueMapValue
    @Default(values = "Beginner")
    private String difficultyLevel;

    @ValueMapValue
    @Optional
    private String description;

    @ValueMapValue
    @Optional
    private String[] tools;

    @ValueMapValue
    @Optional
    private String[] ingredients;

    @ValueMapValue
    @Optional
    private String[] techniques;

    @ValueMapValue
    @Optional
    private String[] proTips;

    @ValueMapValue
    @Optional
    private String demonstrationImage;

    // Getters
    public String getPreparationTitle() {
        return preparationTitle;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTools() {
        return tools != null ? Arrays.asList(tools) : Arrays.asList();
    }

    public List<String> getIngredients() {
        return ingredients != null ? Arrays.asList(ingredients) : Arrays.asList();
    }

    public List<String> getTechniques() {
        return techniques != null ? Arrays.asList(techniques) : Arrays.asList();
    }

    public List<String> getProTips() {
        return proTips != null ? Arrays.asList(proTips) : Arrays.asList();
    }

    public String getDemonstrationImage() {
        return demonstrationImage;
    }

    public String getDifficultyBadgeClass() {
        switch (difficultyLevel) {
            case "Beginner":
                return "badge-success";
            case "Intermediate":
                return "badge-warning";
            case "Advanced":
                return "badge-danger";
            default:
                return "badge-secondary";
        }
    }

    public String getCategoryIcon() {
        switch (foodCategory) {
            case "Vegetables":
                return "🥬";
            case "Meat & Poultry":
                return "🍗";
            case "Fish & Seafood":
                return "🐟";
            case "Grains & Pasta":
                return "🍝";
            default:
                return "🍳";
        }
    }
}
