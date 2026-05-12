package com.example.aem.components;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Sling Model for Review Component
 * Displays product/recipe reviews with detailed feedback and ratings
 */
@Model(adaptables = Resource.class)
public class ReviewComponent {

    @ValueMapValue
    @Optional
    private String reviewTitle;

    @ValueMapValue
    @Optional
    private String reviewContent;

    @ValueMapValue
    @Optional
    private String reviewerName;

    @ValueMapValue
    @Optional
    private Integer overallRating;

    @ValueMapValue
    @Optional
    private Integer tasteRating;

    @ValueMapValue
    @Optional
    private Integer presentationRating;

    @ValueMapValue
    @Optional
    private String reviewDate;

    @ValueMapValue
    @Optional
    private Boolean verified;

    @ValueMapValue
    @Optional
    private Integer helpfulCount;

    public String getReviewTitle() {
        return reviewTitle;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public Integer getOverallRating() {
        return overallRating != null ? overallRating : 0;
    }

    public Integer getTasteRating() {
        return tasteRating != null ? tasteRating : 0;
    }

    public Integer getPresentationRating() {
        return presentationRating != null ? presentationRating : 0;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public Boolean isVerified() {
        return verified != null ? verified : false;
    }

    public Integer getHelpfulCount() {
        return helpfulCount != null ? helpfulCount : 0;
    }

    public Double getAverageRating() {
        int total = getTasteRating() + getPresentationRating() + getOverallRating();
        return total > 0 ? Math.round((total / 3.0) * 10) / 10.0 : 0.0;
    }
}
