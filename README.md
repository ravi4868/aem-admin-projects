# AEM Admin Projects - Recipe & Food Preparation Site

A comprehensive Adobe Experience Manager (AEM) 6.4 project showcasing custom components for recipe management, food preparation guides, and promotional content.

## 🚀 Features

- **Recipe Component**: Display detailed recipes with ingredients, instructions, cooking times, and ratings
- **Food Preparation Component**: Step-by-step food preparation guides with techniques and pro tips
- **Promotional Banner Component**: Eye-catching promotional content with countdown timers and discount badges
- **Recipe Grid Component**: Responsive grid layout for displaying multiple recipes
- **Full-featured Site**: Complete AEM 6.4 implementation with best practices

## 📋 Prerequisites

- Adobe Experience Manager 6.4
- Java 8 or higher
- Maven 3.5.0 or higher
- Node.js (for frontend development)

## 🔧 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/ravi4868/aem-admin-projects.git
cd aem-admin-projects
```

### 2. Build the Project

```bash
mvn clean install
```

### 3. Deploy to AEM

**Author Instance:**
```bash
mvn clean install -PautoInstallPackage -Daem.host=localhost -Daem.port=4502
```

**Publish Instance:**
```bash
mvn clean install -PautoInstallPackage -Daem.host=localhost -Daem.port=4503
```

## 📦 Project Structure

```
aem-admin-projects/
├── core/                          # OSGi bundles
│   ├── src/main/java/
│   │   └── com/example/aem/
│   │       ├── components/        # Sling Models
│   │       ├── models/            # Data Models
│   │       ├── services/          # Business Logic
│   │       └── servlets/          # REST Endpoints
│   └── pom.xml
│
├── ui.apps/                       # Content & Components
│   ├── src/main/content/
│   │   └── jcr_root/apps/aem-admin-projects/
│   │       ├── components/        # Component HTL Templates
│   │       ├── clientlibs/        # CSS/JS
│   │       └── templates/         # Page Templates
│   └── pom.xml
│
├── ui.content/                    # Content & Assets
│   ├── src/main/content/
│   │   └── jcr_root/
│   │       ├── content/           # Sample Pages
│   │       └── etc/               # Configurations
│   └── pom.xml
│
├── pom.xml                        # Parent POM
├── README.md                      # This file
├── DEVELOPMENT.md                 # Development Guide
├── ARCHITECTURE.md                # Architecture Documentation
└── COMPONENTS.md                  # Components Documentation
```

## 📚 Documentation

- **[DEVELOPMENT.md](DEVELOPMENT.md)** - Detailed development guide, setup instructions, and best practices
- **[ARCHITECTURE.md](ARCHITECTURE.md)** - Project architecture, design patterns, and system design
- **[COMPONENTS.md](COMPONENTS.md)** - Component reference, features, and usage examples

## 🎨 Available Components

### Recipe Card Component
Display detailed recipes with ingredients, cooking times, and instructions.

**Path**: `/apps/aem-admin-projects/components/recipes`

**Features**:
- Recipe name and description
- Cuisine type badge
- Prep/Cook time, servings
- Difficulty level
- Ingredients and instructions
- Recipe rating

### Food Preparation Component
Comprehensive cooking technique guides with step-by-step instructions.

**Path**: `/apps/aem-admin-projects/components/food-preparation`

**Features**:
- Technique descriptions
- Tools and equipment lists
- Essential ingredients
- Pro tips and tricks
- Difficulty level

### Promotional Banner Component
Eye-catching promotional content with countdown timers and CTAs.

**Path**: `/apps/aem-admin-projects/components/promo`

**Features**:
- Discount percentage display
- Countdown timer (Days:Hours:Minutes:Seconds)
- Multiple CTAs
- Customizable colors and images
- Terms and conditions

### Recipe Grid Component
Responsive grid layout for displaying multiple recipes.

**Path**: `/apps/aem-admin-projects/components/recipe-grid`

**Features**:
- Responsive CSS Grid
- Auto-fill columns (3 desktop, 2 tablet, 1 mobile)
- Smooth hover animations
- Container component for child items

## 🛠️ Development

### Building Modules

**Build Everything:**
```bash
mvn clean install
```

**Build Specific Module:**
```bash
cd core && mvn clean install
cd ../ui.apps && mvn clean install
```

### Testing

```bash
mvn clean test
```

### Code Style

This project follows AEM best practices:
- Java: Oracle Code Conventions
- HTL: AEM Component Guidelines
- CSS: BEM Naming Convention

## 📖 Quick Start Examples

### Add a Recipe to a Page

1. Go to AEM Author (http://localhost:4502)
2. Create a new page
3. Edit the page
4. Drag "Recipe Card" component from left panel
5. Click to configure:
   - Enter recipe name
   - Add cuisine type
   - Set cooking times
   - Add ingredients and instructions
   - Upload recipe image
6. Publish the page

### Create a Food Preparation Guide

1. Create a new page
2. Add "Food Preparation" component
3. Configure:
   - Set food category
   - Add tools and ingredients
   - Add preparation techniques
   - Add pro tips
4. Publish

### Create a Promotional Campaign

1. Create a new page
2. Add "Promotional Banner" component
3. Configure:
   - Set discount percentage
   - Set campaign dates
   - Add CTAs
   - Customize styling
4. Publish

## 🔍 Troubleshooting

### Build Issues

```bash
# Clean Maven cache
mvn clean -DskipTests

# Force update dependencies
mvn clean install -U
```

### Package Installation Issues

1. Check AEM logs: `http://localhost:4502/system/console/logs`
2. Verify bundle status: `http://localhost:4502/system/console/bundles`
3. Check CRX Package Manager: `http://localhost:4502/crx/packmgr`

### Component Not Appearing

1. Verify component path in dialog
2. Check bundle is active in console
3. Clear browser cache
4. Verify author permissions

## 📝 Configuration

### AEM Host & Port

Modify in root `pom.xml`:
```xml
<aem.host>localhost</aem.host>
<aem.port>4502</aem.port>
```

Or via command line:
```bash
mvn clean install -Daem.host=your-host -Daem.port=your-port
```

## 🚀 Deployment

### Author Instance
```bash
mvn clean install -PautoInstallPackage -Daem.host=author.example.com
```

### Publish Instance
```bash
mvn clean install -PautoInstallPackage -Daem.host=publish.example.com
```

## 📊 Performance

- Components use Sling Models for efficient data binding
- HTL templates are compiled for optimal performance
- ClientLibs are minified and cached
- Image optimization recommended (1200x600px for recipes)

## 🔐 Security

- Components follow AEM security best practices
- XSS protection enabled in HTL
- CSRF tokens included in forms
- User permissions validated at component level

## 📄 License

This project is proprietary to AEM Admin Projects.

## 👥 Contributing

For contribution guidelines, please refer to DEVELOPMENT.md

## 📞 Support

For questions or issues:
1. Check the documentation files (DEVELOPMENT.md, ARCHITECTURE.md, COMPONENTS.md)
2. Review AEM logs in `/crx-quickstart/logs/error.log`
3. Consult AEM Community: https://forums.adobe.com/community/experience-cloud/experience-manager

## 🔗 Resources

- [Adobe Experience Manager Documentation](https://docs.adobe.com/content/help/en/experience-manager-64/user-guide/home.html)
- [AEM Component Development](https://docs.adobe.com/content/help/en/experience-manager-64/developing/components/components.html)
- [Sling Models Documentation](https://sling.apache.org/documentation/bundles/models.html)
- [HTL Language Specification](https://docs.adobe.com/content/help/en/experience-manager-htl/using/overview.html)

---

**Version**: 1.0.0  
**Last Updated**: 2026-05-11  
**Maintained by**: ravi4868