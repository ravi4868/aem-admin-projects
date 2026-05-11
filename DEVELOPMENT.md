# AEM Admin Projects - Development Guide

## 🚀 Getting Started

### Prerequisites
- Adobe Experience Manager 6.4
- Java 8 or higher
- Maven 3.5.0+
- Git

### Local Setup

1. **Clone the Repository**
```bash
git clone https://github.com/ravi4868/aem-admin-projects.git
cd aem-admin-projects
```

2. **Build the Project**
```bash
mvn clean install
```

3. **Deploy to Local AEM Instance**
```bash
# Deploy to Author (port 4502)
mvn clean install -PautoInstallPackage -Daem.host=localhost -Daem.port=4502

# Deploy to Publish (port 4503)
mvn clean install -PautoInstallPackage -Daem.host=localhost -Daem.port=4503
```

## 📁 Project Structure

### Core Module (`core/`)
OSGi bundles containing:
- **Sling Models**: Component logic (Adaptables)
- **Services**: Business logic for recipes, food prep, etc.
- **Models**: Data classes
- **Servlets**: REST endpoints

### UI Apps Module (`ui.apps/`)
Content packages with:
- **Components**: HTL templates (.html files)
- **Dialogs**: Component configuration (.content.xml)
- **ClientLibs**: CSS and JavaScript
- **Templates**: Page templates

### UI Content Module (`ui.content/`)
Content packages with:
- **Sample Pages**: Demo content
- **Assets**: Images and media files
- **Configurations**: Site settings
- **Templates**: Template definitions

## 🔧 Development Workflow

### Adding a New Component

1. **Create Sling Model** (`core/src/main/java/`)
```java
@Model(adaptables = Resource.class)
public class MyComponent {
    @ValueMapValue
    @Optional
    private String title;
    
    public String getTitle() {
        return title;
    }
}
```

2. **Create HTL Template** (`ui.apps/src/main/content/jcr_root/apps/aem-admin-projects/components/mycomponent/`)
```html
<div class="my-component" data-sly-use.comp="com.example.aem.components.MyComponent">
    <h1>${comp.title}</h1>
</div>
```

3. **Create Component Dialog** (`ui.apps/.../components/mycomponent/_cq_dialog/.content.xml`)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<jcr:root xmlns:cq="http://www.day.com/jcr/cq/1.0"
          jcr:primaryType="cq:Dialog">
    <items jcr:primaryType="cq:TabPanel">
        <basic jcr:primaryType="cq:Panel" title="Basic">
            <items jcr:primaryType="cq:WidgetCollection">
                <title jcr:primaryType="cq:Widget" xtype="textfield" name="./title"/>
            </items>
        </basic>
    </items>
</jcr:root>
```

4. **Build and Deploy**
```bash
mvn clean install -PautoInstallPackage
```

### Adding a New Service

1. **Create Service Interface** (`core/src/main/java/.../services/`)
```java
@Component(service = MyService.class)
public class MyServiceImpl implements MyService {
    @Activate
    protected void activate() {
        // Service initialization
    }
}
```

2. **Inject into Sling Model**
```java
@Model(adaptables = Resource.class)
public class MyComponent {
    @OSGiService
    private MyService myService;
}
```

### Creating a New Page

1. Open AEM Author (http://localhost:4502)
2. Navigate to `/content/aem-admin-projects`
3. Click "Create" → "Page"
4. Select "Page Template"
5. Enter page title and click "Create"
6. Edit the page and drag components into the container
7. Configure component properties via dialogs
8. Publish the page

## 🧪 Testing

### Unit Tests
```bash
# Run all tests
mvn clean test

# Run specific test class
mvn test -Dtest=RecipeServiceImplTest
```

### Manual Testing in AEM

1. **Component Testing**
   - Create a test page
   - Add component
   - Verify rendering and functionality

2. **Service Testing**
   - Open OSGi console: http://localhost:4502/system/console/components
   - Search for your service
   - Verify it's active

## 📊 Maven Commands

```bash
# Clean build
mvn clean install

# Skip tests
mvn clean install -DskipTests

# Build specific module
cd core && mvn clean install

# Deploy with custom host/port
mvn clean install -Daem.host=your-host -Daem.port=8080

# Force update dependencies
mvn clean install -U

# View project structure
mvn clean package
```

## 🐛 Debugging

### Enable Debug Mode
```bash
# Start AEM with debug enabled
cd crx-quickstart/bin
./quickstart -debug 5005
```

### View Logs
```bash
# Tail error log
tail -f crx-quickstart/logs/error.log

# View in AEM console
http://localhost:4502/system/console/logs
```

### Common Issues

**Component not showing in sidebar**
- Check component group in .content.xml
- Verify bundle is active in OSGi console
- Clear browser cache

**Sling Model not adapting**
- Ensure @Model annotation is present
- Check @OsgiService imports
- Verify bundle is active

**HTL template errors**
- Check error.log for syntax errors
- Verify use-api class exists
- Check data-sly-use paths

## 📚 Best Practices

1. **Code Organization**
   - Keep components in separate packages
   - Use meaningful class names
   - Follow AEM naming conventions

2. **Performance**
   - Use Sling Models for data binding
   - Minimize dialog complexity
   - Optimize images before upload

3. **Security**
   - Always validate user input
   - Use XSS protection in HTL
   - Implement proper ACLs

4. **Testing**
   - Write unit tests for services
   - Test components with sample data
   - Verify on multiple browsers

## 🔗 Useful Links

- [AEM Documentation](https://docs.adobe.com/content/help/en/experience-manager-64/user-guide/home.html)
- [Sling Models](https://sling.apache.org/documentation/bundles/models.html)
- [HTL Specification](https://docs.adobe.com/content/help/en/experience-manager-htl/using/overview.html)
- [Core Components](https://github.com/adobe/aem-core-wcm-components)

## 📞 Support

For issues or questions:
1. Check the logs
2. Review the documentation
3. Check AEM console status
4. Review similar components in the codebase

## 📝 Git Workflow

```bash
# Create feature branch
git checkout -b feature/my-feature

# Make changes and commit
git add .
git commit -m "Add my feature"

# Push to repository
git push origin feature/my-feature

# Create Pull Request on GitHub
```

---

**Last Updated**: 2026-05-11  
**Version**: 1.0.0