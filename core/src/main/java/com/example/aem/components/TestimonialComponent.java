package com.example.aem.components;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/**
 * Sling Model for Testimonial Component
 * Displays customer testimonials with author information and ratings
 */
@Model(adaptables = Resource.class)
public class TestimonialComponent {

    @ValueMapValue
    @Optional
    private String testimonialText;

    @ValueMapValue
    @Optional
    private String authorName;

    @ValueMapValue
    @Optional
    private String authorRole;

    @ValueMapValue
    @Optional
    private String authorImage;

    @ValueMapValue
    @Optional
    private Integer rating;

    @ValueMapValue
    @Optional
    private String authorCompany;

    @ValueMapValue
    @Optional
    private Boolean featured;

    public String getTestimonialText() {
        return testimonialText;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorRole() {
        return authorRole;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public Integer getRating() {
        return rating != null ? rating : 0;
    }

    public String getAuthorCompany() {
        return authorCompany;
    }

    public Boolean isFeatured() {
        return featured != null ? featured : false;
    }

    public String getRatingStars() {
        StringBuilder stars = new StringBuilder();
        int rate = getRating();
        for (int i = 0; i < 5; i++) {
            stars.append(i < rate ? "★" : "☆");
        }
        return stars.toString();
    }
}
