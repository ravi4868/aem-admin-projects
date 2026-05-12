package com.example.aem.components;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/**
 * Sling Model for Feature Highlight Component
 * Displays key features with icons and descriptions
 */
@Model(adaptables = Resource.class)
public class FeatureHighlightComponent {

    @ValueMapValue
    @Optional
    private String sectionTitle;

    @ValueMapValue
    @Optional
    private String sectionDescription;

    @ValueMapValue
    @Optional
    private String feature1Title;

    @ValueMapValue
    @Optional
    private String feature1Description;

    @ValueMapValue
    @Optional
    private String feature1Icon;

    @ValueMapValue
    @Optional
    private String feature2Title;

    @ValueMapValue
    @Optional
    private String feature2Description;

    @ValueMapValue
    @Optional
    private String feature2Icon;

    @ValueMapValue
    @Optional
    private String feature3Title;

    @ValueMapValue
    @Optional
    private String feature3Description;

    @ValueMapValue
    @Optional
    private String feature3Icon;

    @ValueMapValue
    @Optional
    private String feature4Title;

    @ValueMapValue
    @Optional
    private String feature4Description;

    @ValueMapValue
    @Optional
    private String feature4Icon;

    @ValueMapValue
    @Optional
    private String layoutStyle;

    public String getSectionTitle() {
        return sectionTitle;
    }

    public String getSectionDescription() {
        return sectionDescription;
    }

    public String getFeature1Title() {
        return feature1Title;
    }

    public String getFeature1Description() {
        return feature1Description;
    }

    public String getFeature1Icon() {
        return feature1Icon;
    }

    public String getFeature2Title() {
        return feature2Title;
    }

    public String getFeature2Description() {
        return feature2Description;
    }

    public String getFeature2Icon() {
        return feature2Icon;
    }

    public String getFeature3Title() {
        return feature3Title;
    }

    public String getFeature3Description() {
        return feature3Description;
    }

    public String getFeature3Icon() {
        return feature3Icon;
    }

    public String getFeature4Title() {
        return feature4Title;
    }

    public String getFeature4Description() {
        return feature4Description;
    }

    public String getFeature4Icon() {
        return feature4Icon;
    }

    public String getLayoutStyle() {
        return layoutStyle != null ? layoutStyle : "grid";
    }
}
