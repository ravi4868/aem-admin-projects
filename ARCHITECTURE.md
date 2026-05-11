# AEM Admin Projects - Architecture Documentation

## System Architecture

### Overview
AEM Admin Projects is built on Adobe Experience Manager 6.4, leveraging Sling Models, OSGi services, and HTL templates to create a scalable, maintainable recipe and food preparation website.

## Technology Stack

- **Framework**: Adobe Experience Manager 6.4
- **Backend Language**: Java 8
- **Component Models**: Sling Models
- **Templating**: HTL (HTML Template Language)
- **Build Tool**: Maven 3.5+
- **Build Dependency**: OSGi
- **Content Storage**: JCR (Java Content Repository)
- **Frontend**: HTML5, CSS3, Bootstrap

## High-Level Architecture

```
┌─────────────────────────────────────────────────────────┐
│                  Client (Browser)                        │
│                 (HTML5, CSS3, JS)                        │
└────────────────────┬────────────────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────────────────┐
│              AEM Publish/Author Instance                │
│  ┌──────────────────────────────────────────────────┐  │
│  │          HTTP Request Handler (Dispatcher)       │  │
│  └─────────────────┬────────────────────────────────┘  │
│                    │                                    │
│  ┌─────────────────▼────────────────────────────────┐  │
│  │          Sling Request Processing                │  │
│  │  (Resolution, Adaptation, Rendering)           │  │
│  └─────────────────┬────────────────────────────────┘  │
│                    │                                    │
│  ┌─────────────────▼────────────────────────────────┐  │
│  │         Component Rendering (HTL)              │  │
│  │  ┌──────────────────────────────────────────┐  │  │
│  │  │  Recipe Component                        │  │  │
│  │  │  Food Preparation Component              │  │  │
│  │  │  Promo Component                         │  │  │
│  │  │  Recipe Grid Component                   │  │  │
│  │  └──────────────────────────────────────────┘  │  │
│  └─────────────────┬────────────────────────────────┘  │
│                    │                                    │
│  ┌─────────────────▼────────────────────────────────┐  │
│  │       Sling Models (Data Binding)               │  │
│  │  ┌──────────────────────────────────────────┐  │  │
│  │  │  RecipeComponent                         │  │  │
│  │  │  FoodPreparationComponent                │  │  │
│  │  │  PromoComponent                          │  │  │
│  │  │  RecipeGridComponent                     │  │  │
│  │  └──────────────────────────────────────────┘  │  │
│  └─────────────────┬────────────────────────────────┘  │
│                    │                                    │
│  ┌─────────────────▼────────────────────────────────┐  │
│  │        OSGi Services (Business Logic)           │  │
│  │  ┌──────────────────────────────────────────┐  │  │
│  │  │  RecipeService                           │  │  │
│  │  │  RecipeServiceImpl                        │  │  │
│  │  └──────────────────────────────────────────┘  │  │
│  └─────────────────┬────────────────────────────────┘  │
│                    │                                    │
│  ┌─────────────────▼────────────────────────────────┐  │
│  │            JCR Content Repository               │  │
│  │  ┌──────────────────────────────────────────┐  │  │
│  │  │  /content/aem-admin-projects/recipes     │  │  │
│  │  │  /apps/aem-admin-projects/components     │  │  │
│  │  │  /etc/designs/aem-admin-projects         │  │  │
│  │  └──────────────────────────────────────────┘  │  │
│  └──────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────┘
```

## Module Architecture

### 1. Core Bundle (`aem-admin-projects-core`)
Contains backend logic and OSGi services.

**Structure:**
```
core/
├── src/main/java/com/example/aem/
│   ├── components/
│   │   ├── RecipeComponent.java
│   │   ├── FoodPreparationComponent.java
│   │   ├── PromoComponent.java
│   │   └── RecipeGridComponent.java
│   ├── models/
│   │   └── Recipe.java
│   ├── services/
│   │   ├── RecipeService.java
│   │   └── impl/RecipeServiceImpl.java
│   └── servlets/
│       └── RecipeServlet.java
└── src/test/java/ (Unit Tests)
```

**Key Classes:**

- **RecipeComponent**: Sling Model for recipe display
- **FoodPreparationComponent**: Sling Model for food prep guides
- **PromoComponent**: Sling Model for promotional banners
- **RecipeService**: Interface for recipe management
- **Recipe**: Domain model for recipe data

### 2. UI Apps Module (`aem-admin-projects-ui.apps`)
Contains components, templates, and client libraries.

**Structure:**
```
ui.apps/
└── src/main/content/jcr_root/apps/aem-admin-projects/
    ├── components/
    │   ├── recipes/
    │   │   ├── recipe.html
    │   │   ├── .content.xml
    │   │   └── _cq_dialog/.content.xml
    │   ├── food-preparation/
    │   ├── promo/
    │   │   ├── promo.html
    │   │   ├── clientlib/css/promo.css
    │   │   └── _cq_dialog/.content.xml
    │   └── recipe-grid/
    ├── clientlibs/
    │   └── css/ & js/
    └── templates/
```

**Component Features:**

| Component | Type | Features |
|-----------|------|----------|
| Recipe Card | Leaf | Recipe details, ingredients, instructions |
| Food Prep | Leaf | Guides, techniques, pro tips |
| Promo Banner | Leaf | Countdown timer, discount badges, CTAs |
| Recipe Grid | Container | Responsive grid for multiple components |

### 3. UI Content Module (`aem-admin-projects-ui.content`)
Contains sample pages and site configuration.

**Structure:**
```
ui.content/
└── src/main/content/jcr_root/
    ├── content/aem-admin-projects/
    │   ├── recipes/
    │   ├── food-prep/
    │   └── promotions/
    ├── conf/aem-admin-projects/
    │   └── settings/wcm/templates/
    └── etc/designs/aem-admin-projects/
```

## Data Flow

### 1. Page Request Flow
```
1. Browser requests URL (e.g., /content/aem-admin-projects/recipes)
   │
2. Sling processes request and resolves to resource
   │
3. Resource is adapted to Sling Model (e.g., RecipeComponent)
   │
4. HTL template uses Sling Model
   │
5. HTL renders output (HTML)
   │
6. HTML is returned to browser
```

### 2. Component Data Binding
```
JCR Node (.content.xml)
    │
    ▼
ValueMapValue annotation
    │
    ▼
Sling Model Class
    │
    ▼
HTL Template (data-sly-use)
    │
    ▼
Rendered HTML
```

### 3. Service Usage
```
Sling Model
    │
    ▼
@OSGiService injection
    │
    ▼
RecipeService.getAllRecipes()
    │
    ▼
In-memory store (production: JCR)
    │
    ▼
Return List<Recipe>
```

## Component Lifecycle

### 1. Authoring
```
Author creates page → Configures component dialog → Properties saved to JCR
```

### 2. Rendering
```
Request received → Sling Model instantiated → HTL template processes data → HTML rendered
```

### 3. Deployment
```
Developer builds → Maven packages content → Deploys via content package → Pages render on publish
```

## Design Patterns Used

### 1. Sling Model Pattern
```java
@Model(adaptables = Resource.class)
public class RecipeComponent {
    @ValueMapValue
    @Optional
    private String recipeName;
    
    public String getRecipeName() {
        return recipeName;
    }
}
```

### 2. Service Layer Pattern
```java
@Component(service = RecipeService.class)
public class RecipeServiceImpl implements RecipeService {
    // Business logic implementation
}
```

### 3. Dependency Injection
```java
@Model(adaptables = Resource.class)
public class MyComponent {
    @OSGiService
    private RecipeService recipeService;
}
```

### 4. Observer Pattern (OSGi Services)
Services are discovered and injected automatically by OSGi container.

## Scalability Considerations

### Caching
- Leverage dispatcher caching for static pages
- Implement application-level caching for service results
- Use AEM's content-based caching strategies

### Performance Optimization
1. **Database Queries**: Currently in-memory, can be moved to persistent storage
2. **Image Optimization**: Compress images to <200KB
3. **CDN Integration**: Serve static assets via CDN
4. **Load Balancing**: Deploy multiple AEM instances behind load balancer

### Security Architecture

```
┌──────────────────────────────┐
│  WAF (Web Application        │
│  Firewall)                   │
└──────────────────────────────┘
           │
           ▼
┌──────────────────────────────┐
│  Load Balancer               │
│  (HTTPS/SSL)                 │
└──────────────────────────────┘
           │
     ┌─────┴─────┐
     ▼           ▼
┌─────────┐ ┌─────────┐
│  AEM    │ │  AEM    │
│ Author  │ │Publish  │
└────┬────┘ └────┬────┘
     │           │
     └─────┬─────┘
           ▼
   ┌──────────────────┐
   │  JCR Repository  │
   │  (Permissions)   │
   └──────────────────┘
```

## Deployment Architecture

### Development
```
Local AEM Instance (port 4502)
  │
  ├─ Author (Authoring)
  └─ Publish (Preview)
```

### Production
```
Production Environment
  │
  ├─ Author Cluster
  │  ├─ Author 1
  │  ├─ Author 2
  │  └─ Dispatcher
  │
  ├─ Publish Cluster
  │  ├─ Publish 1
  │  ├─ Publish 2
  │  ├─ Publish 3
  │  └─ Dispatcher
  │
  └─ Shared Repository (TarMK or MongoMK)
```

## Extensibility

### Adding New Components
Follow the component creation pattern:
1. Create Sling Model with @Model annotation
2. Create HTL template
3. Create dialog configuration
4. Add to component group

### Adding New Services
1. Create service interface
2. Create implementation with @Component
3. Inject into Sling Models via @OSGiService

### Custom Client Libraries
Add CSS/JS to component clientlib directory:
```
components/mycomponent/
└─ clientlib/
   ├─ css/
   │  └─ mycomponent.css
   └─ js/
      └─ mycomponent.js
```

## Monitoring & Logging

### Logs
- **Location**: `crx-quickstart/logs/error.log`
- **View in AEM**: System > Status > Log Messages

### Health Checks
1. OSGi Bundle Status: `localhost:4502/system/console/bundles`
2. Services Status: `localhost:4502/system/console/services`
3. Components Status: `localhost:4502/system/console/components`

## Version Control & CI/CD

### Git Workflow
```
main (production)
  │
  └─ develop (development)
      │
      └─ feature/* (features)
```

### Build Pipeline
```
Git Commit
  │
  ▼
Maven Build (mvn clean install)
  │
  ▼
Unit Tests
  │
  ▼
Content Package Creation
  │
  ▼
Deploy to Target Environment
```

## Conclusion

This architecture provides a solid foundation for building scalable, maintainable AEM applications. The separation of concerns (core, ui.apps, ui.content), use of modern design patterns, and adherence to AEM best practices ensure the system can grow and evolve as requirements change.

---

**Last Updated**: 2026-05-11  
**Version**: 1.0.0