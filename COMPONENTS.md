# AEM Admin Projects - Components Documentation

## Overview

AEM Admin Projects features four main components designed to create a comprehensive recipe and food preparation website. Each component is fully configurable through AEM's authoring interface.

## Component Reference

### 1. Recipe Card Component

**Resource Type**: `aem-admin-projects/components/recipes`

**Description**: Displays detailed recipe information with ingredients, instructions, and metadata.

**Dialog Fields**:
- Basic Information Tab
  - Recipe Name (Text field, required)
  - Description (Text area)
  - Cuisine Type (Selection: Italian, Indian, Mexican, Chinese, French)

- Recipe Details Tab
  - Prep Time (Number field, in minutes)
  - Cook Time (Number field, in minutes)
  - Servings (Number field)
  - Difficulty Level (Selection: Easy, Medium, Hard)
  - Rating (Number field, 0-5)

- Ingredients & Instructions Tab
  - Ingredients (Multi-field with text input)
  - Instructions (Multi-field with textarea)

- Media Tab
  - Recipe Image (Image selector)

**Sling Model**: `com.example.aem.components.RecipeComponent`

**CSS Classes**:
- `.recipe-card` - Main container
- `.recipe-header` - Header section with image
- `.recipe-body` - Content area
- `.recipe-title` - Recipe name
- `.recipe-meta` - Metadata section (time, servings, etc.)
- `.ingredients-list` - Ingredients list
- `.instructions-list` - Instructions list

**Features**:
- Auto-calculated total cooking time
- Cuisine-specific emoji display
- Difficulty level color-coded badges
- Responsive grid layout
- Star rating display
- Print-friendly design

**Example Usage**:
```html
<sly data-sly-resource="recipe" data-sly-resourceType="aem-admin-projects/components/recipes"/>
```

---

### 2. Food Preparation Component

**Resource Type**: `aem-admin-projects/components/food-preparation`

**Description**: Provides step-by-step cooking technique guides with professional tips.

**Dialog Fields**:
- Basic Information Tab
  - Preparation Title (Text field, required)
  - Food Category (Selection: Vegetables, Meat & Poultry, Fish & Seafood, Grains & Pasta)
  - Difficulty Level (Selection: Beginner, Intermediate, Advanced)
  - Description (Text area)

- Tools & Ingredients Tab
  - Tools Required (Multi-field)
  - Essential Ingredients (Multi-field)

- Techniques Tab
  - Preparation Techniques (Multi-field)
  - Pro Tips & Tricks (Multi-field with textarea)

- Media Tab
  - Demonstration Image (Image selector)

**Sling Model**: `com.example.aem.components.FoodPreparationComponent`

**CSS Classes**:
- `.food-prep-component` - Main container
- `.food-prep-header` - Header section
- `.food-prep-body` - Content area
- `.tools-section` - Tools list
- `.ingredients-section` - Ingredients list
- `.techniques-section` - Accordion with techniques
- `.pro-tips-section` - Pro tips list

**Features**:
- Accordion-based technique steps
- Categorized tools and equipment
- Professional tips integration
- Category-specific icons
- Responsive design
- Accessible structure

**Example Usage**:
```html
<sly data-sly-resource="foodprep" data-sly-resourceType="aem-admin-projects/components/food-preparation"/>
```

---

### 3. Promotional Banner Component

**Resource Type**: `aem-admin-projects/components/promo`

**Description**: Creates eye-catching promotional banners with countdown timers and multiple CTAs.

**Dialog Fields**:
- Content Tab
  - Promo Tag (Text field)
  - Promo Title (Text field, required)
  - Subtitle (Text area)
  - Key Highlights (Multi-field)

- Offer Details Tab
  - Discount Percentage (Number field, 0-100)
  - Start Date (Date field)
  - End Date (Date field)
  - Terms & Conditions (Text area)

- Call to Action Tab
  - Primary CTA Text (Text field, default: "Shop Now")
  - Primary CTA URL (Text field)
  - Secondary CTA Text (Text field, default: "Learn More")
  - Secondary CTA URL (Text field)

- Styling Tab
  - Background Color (Text field, hex color)
  - Background Image (Image selector)

**Sling Model**: `com.example.aem.components.PromoComponent`

**CSS Classes**:
- `.promo-banner` - Main container
- `.promo-wrapper` - Content wrapper
- `.promo-title` - Main title
- `.promo-subtitle` - Subtitle
- `.discount-badge` - Discount display
- `.countdown-timer` - Timer container
- `.countdown-item` - Individual time unit (days, hours, minutes, seconds)
- `.highlights-list` - Key highlights list
- `.promo-actions` - CTA buttons container

**Features**:
- Live countdown timer (auto-updating)
- Dynamic discount badge coloring
- Responsive button layout
- Inline background color and image support
- Multiple highlight points
- Terms and conditions display
- Accessibility compliant

**Countdown Timer Features**:
- Auto-updates every second
- Shows days, hours, minutes, seconds
- Displays "OFFER EXPIRED" when timer reaches zero
- Smooth animations

**Example Usage**:
```html
<sly data-sly-resource="promo" data-sly-resourceType="aem-admin-projects/components/promo"/>
```

---

### 4. Recipe Grid Component

**Resource Type**: `aem-admin-projects/components/recipe-grid`

**Description**: Container component for displaying multiple components (especially recipes) in a responsive grid layout.

**Dialog Fields**:
- Grid Title (Text field)
- Grid Description (Text area)
- Columns Desktop (Selection: 2, 3, 4)
- Columns Tablet (Selection: 1, 2, 3)
- Columns Mobile (Selection: 1, 2)

**Sling Model**: `com.example.aem.components.RecipeGridComponent`

**CSS Classes**:
- `.recipe-grid-wrapper` - Main wrapper
- `.recipe-grid-header` - Header section
- `.recipe-grid` - Grid container
- `.recipe-grid-desktop-3` - Desktop 3-column layout
- `.recipe-grid-tablet-2` - Tablet 2-column layout
- `.recipe-grid-mobile-1` - Mobile 1-column layout

**Features**:
- Responsive CSS Grid
- Auto-fill columns based on screen size
- Configurable column count
- Child component support (container)
- Header title and description
- Smooth hover effects
- Mobile-first design

**Layout Specifications**:
- Desktop: 3 columns (300px min-width per column)
- Tablet: 2 columns (200px min-width per column)
- Mobile: 1 column (full width)

**Example Usage**:
```html
<sly data-sly-resource="recipe-grid" data-sly-resourceType="aem-admin-projects/components/recipe-grid"/>
```

---

## Service Layer

### RecipeService

**Interface**: `com.example.aem.services.RecipeService`

**Implementation**: `com.example.aem.services.impl.RecipeServiceImpl`

**Available Methods**:

```java
// Retrieve all recipes
List<Recipe> getAllRecipes()

// Filter recipes by cuisine type
List<Recipe> getRecipesByCuisine(String cuisineType)

// Filter recipes by difficulty level
List<Recipe> getRecipesByDifficulty(String difficultyLevel)

// Get a specific recipe by name
Recipe getRecipeByName(String recipeName)

// Full-text search in recipes
List<Recipe> searchRecipes(String keyword)

// Get featured recipes
List<Recipe> getFeaturedRecipes()

// Create a new recipe
Recipe createRecipe(Recipe recipe)

// Update an existing recipe
Recipe updateRecipe(Recipe recipe)

// Delete a recipe
boolean deleteRecipe(String recipeId)

// Get recipe by ID
Recipe getRecipeById(String recipeId)
```

**Sample Data Included**:
1. Pasta Carbonara (Italian)
2. Butter Chicken (Indian)

---

## Data Model

### Recipe Class

**Package**: `com.example.aem.models`

**Properties**:
- `id` - Unique identifier
- `recipeName` - Name of the recipe
- `description` - Detailed description
- `cuisineType` - Type of cuisine
- `prepTime` - Preparation time in minutes
- `cookTime` - Cooking time in minutes
- `servings` - Number of servings
- `difficultyLevel` - Easy/Medium/Hard
- `rating` - Rating from 0 to 5
- `imageUrl` - URL to recipe image
- `ingredientsList` - List of ingredients
- `instructionsList` - Step-by-step instructions
- `featured` - Whether recipe is featured
- `author` - Recipe author name

**Useful Methods**:
- `getTotalTime()` - Returns sum of prep and cook time

---

## Client Libraries

### Main Client Library
**Category**: `aem-admin-projects.main`
**Dependencies**: `cq.jquery`

Includes:
- Global styles (colors, spacing, utilities)
- Main JavaScript initialization
- Countdown timer functionality
- Utility methods

### Recipe Client Library
**Category**: `aem-admin-projects.recipes`
**Dependencies**: `aem-admin-projects.main`

Includes:
- Recipe-specific styling
- Ingredient and instruction list styles
- Responsive recipe card layout

---

## Component Groups

Components are organized into two groups:

### Content Group
- Recipe Card
- Food Preparation
- Recipe Grid

### Marketing Group
- Promotional Banner

---

## Best Practices

### When Creating Recipe Content
1. **Images**: Upload recipes images at 1200x600px or larger
2. **Names**: Use clear, descriptive recipe names
3. **Descriptions**: Keep descriptions under 200 characters
4. **Ingredients**: Use consistent formatting (quantity + unit + item)
5. **Instructions**: Number steps sequentially and keep them brief
6. **Difficulty**: Match difficulty to actual recipe complexity

### When Creating Promotional Banners
1. **Colors**: Ensure sufficient contrast for readability
2. **Text**: Keep titles short and impactful
3. **CTA**: Use clear, action-oriented button text
4. **Dates**: Always set end dates for limited-time offers
5. **Discount**: Use realistic percentages (30-70%)

### Performance Optimization
1. **Images**: Compress before uploading (<200KB per image)
2. **Content**: Limit ingredients/instructions to 20 items max
3. **Dialogs**: Don't add unnecessary fields
4. **Caching**: Leverage AEM's caching for static pages

---

## Troubleshooting

### Component Not Displaying
1. Verify bundle is active in OSGi console
2. Check browser console for JavaScript errors
3. Clear browser cache and reload
4. Verify component group is set in .content.xml

### Dialog Fields Not Saving
1. Check error.log for validation errors
2. Verify field names match Sling Model properties
3. Ensure proper XML syntax in dialog definition

### Images Not Appearing
1. Verify image is uploaded correctly
2. Check image path in component
3. Ensure image has appropriate permissions
4. Verify image format is supported (JPEG, PNG, GIF, WebP)

### Countdown Timer Not Working
1. Ensure JavaScript is enabled
2. Verify end date is in valid format (YYYY-MM-DD)
3. Check browser console for JavaScript errors
4. Ensure countdown element has correct ID

---

## Future Enhancements

- [ ] Recipe rating and review system
- [ ] Shopping list generation from recipes
- [ ] Nutritional information display
- [ ] Video integration for cooking techniques
- [ ] Mobile app integration
- [ ] AI-powered recipe recommendations
- [ ] Social media sharing integration
- [ ] Print-friendly recipe layouts
- [ ] Recipe bookmarking and collections
- [ ] Multi-language support

---

**Version**: 1.0.0  
**Last Updated**: 2026-05-11  
**Maintained by**: AEM Admin Projects Team