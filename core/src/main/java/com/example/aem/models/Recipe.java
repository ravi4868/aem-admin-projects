package com.example.aem.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Recipe Model class for storing recipe data
 */
public class Recipe {
    private String id;
    private String recipeName;
    private String description;
    private String cuisineType;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String difficultyLevel;
    private Double rating;
    private String imageUrl;
    private List<String> ingredientsList;
    private List<String> instructionsList;
    private Boolean featured;
    private String author;

    public Recipe() {
        this.ingredientsList = new ArrayList<>();
        this.instructionsList = new ArrayList<>();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<String> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public List<String> getInstructionsList() {
        return instructionsList;
    }

    public void setInstructionsList(List<String> instructionsList) {
        this.instructionsList = instructionsList;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Calculate total cooking time
     */
    public Integer getTotalTime() {
        int total = 0;
        if (prepTime != null) {
            total += prepTime;
        }
        if (cookTime != null) {
            total += cookTime;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", cuisineType='" + cuisineType + '\'' +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                '}';
    }
}
