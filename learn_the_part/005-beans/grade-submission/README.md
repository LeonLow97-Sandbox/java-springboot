# Beans and Dependency Injection

## How is a Bean created?

1. A `@Component` class is automatically discovered by Spring.
  - When running a spring boot application, spring boot scans your project for component classes and any class annotated with component is automatically discovered.
2. Spring creates an object out of each `@Component` class that it finds.
3. A Spring container called ApplicationContext stores and manages the object.
  - **Bean**: an object that lives inside the Spring container AKA ApplicationContext.



