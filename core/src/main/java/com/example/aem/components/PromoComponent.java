package com.example.aem.components;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Sling Model for Promotional Banner Component
 */
@Model(adaptables = Resource.class)
public class PromoComponent {

    @ValueMapValue
    @Optional
    private String promoTag;

    @ValueMapValue
    @Optional
    private String promoTitle;

    @ValueMapValue
    @Optional
    private String promoSubtitle;

    @ValueMapValue
    @Optional
    private String[] keyHighlights;

    @ValueMapValue
    @Optional
    private Integer discountPercentage;

    @ValueMapValue
    @Optional
    private String promoStartDate;

    @ValueMapValue
    @Optional
    private String promoEndDate;

    @ValueMapValue
    @Optional
    private String termsConditions;

    @ValueMapValue
    @Optional
    private String primaryCtaText;

    @ValueMapValue
    @Optional
    private String primaryCtaUrl;

    @ValueMapValue
    @Optional
    private String secondaryCtaText;

    @ValueMapValue
    @Optional
    private String secondaryCtaUrl;

    @ValueMapValue
    @Default(values = "#FF6B35")
    private String backgroundColor;

    @ValueMapValue
    @Optional
    private String backgroundImage;

    // Getters
    public String getPromoTag() {
        return promoTag;
    }

    public String getPromoTitle() {
        return promoTitle;
    }

    public String getPromoSubtitle() {
        return promoSubtitle;
    }

    public List<String> getKeyHighlights() {
        return keyHighlights != null ? Arrays.asList(keyHighlights) : Arrays.asList();
    }

    public Integer getDiscountPercentage() {
        return discountPercentage != null ? discountPercentage : 0;
    }

    public String getPromoStartDate() {
        return promoStartDate;
    }

    public String getPromoEndDate() {
        return promoEndDate;
    }

    public String getTermsConditions() {
        return termsConditions;
    }

    public String getPrimaryCtaText() {
        return primaryCtaText != null ? primaryCtaText : "Shop Now";
    }

    public String getPrimaryCtaUrl() {
        return primaryCtaUrl;
    }

    public String getSecondaryCtaText() {
        return secondaryCtaText != null ? secondaryCtaText : "Learn More";
    }

    public String getSecondaryCtaUrl() {
        return secondaryCtaUrl;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public boolean isPromoActive() {
        if (promoEndDate == null) {
            return true;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date endDate = sdf.parse(promoEndDate);
            return new Date().before(endDate);
        } catch (Exception e) {
            return true;
        }
    }

    public String getDiscountBadgeStyle() {
        if (getDiscountPercentage() > 50) {
            return "badge-danger";
        } else if (getDiscountPercentage() > 30) {
            return "badge-warning";
        } else {
            return "badge-success";
        }
    }

    public String getInlineStyle() {
        StringBuilder style = new StringBuilder();
        if (backgroundColor != null && !backgroundColor.isEmpty()) {
            style.append("background-color: ").append(backgroundColor).append(";");
        }
        if (backgroundImage != null && !backgroundImage.isEmpty()) {
            style.append("background-image: url('").append(backgroundImage).append("');");
            style.append("background-size: cover; background-position: center;");
        }
        return style.toString();
    }
}
