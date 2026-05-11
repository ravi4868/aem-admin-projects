package com.example.aem.components;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/**
 * Sling Model for Recipe Grid Component
 * Container component for displaying multiple recipe cards
 */
@Model(adaptables = Resource.class)
public class RecipeGridComponent {

    @ValueMapValue
    @Optional
    private String gridTitle;

    @ValueMapValue
    @Optional
    private String gridDescription;

    @ValueMapValue
    @Optional
    private String columnsDesktop;

    @ValueMapValue
    @Optional
    private String columnsTablet;

    @ValueMapValue
    @Optional
    private String columnsMobile;

    // Getters
    public String getGridTitle() {
        return gridTitle;
    }

    public String getGridDescription() {
        return gridDescription;
    }

    public String getColumnsDesktop() {
        return columnsDesktop != null ? columnsDesktop : "3";
    }

    public String getColumnsTablet() {
        return columnsTablet != null ? columnsTablet : "2";
    }

    public String getColumnsMobile() {
        return columnsMobile != null ? columnsMobile : "1";
    }

    public String getGridCssClasses() {
        return "recipe-grid recipe-grid-desktop-" + getColumnsDesktop() +
                " recipe-grid-tablet-" + getColumnsTablet() +
                " recipe-grid-mobile-" + getColumnsMobile();
    }
}
