# Beans and Dependency Injection

- [Beans and Dependency Injection CheatSheet](https://www.learnthepart.com/course/af54547f-e993-47bd-ad51-d7c7270c4e50/e210efe0-6347-4914-b6e9-3abe7e0755f0)

## How is a Bean created?

1. A `@Component` class is automatically discovered by Spring.

- When running a spring boot application, spring boot scans your project for component classes and any class annotated with component is automatically discovered.

2. Spring creates an object out of each `@Component` class that it finds.
3. A Spring container called ApplicationContext stores and manages the object.

- **Bean**: an object that lives inside the Spring container AKA ApplicationContext.
  - Component turns a class into a bean.

## Dependency Injection

- Never create an object/dependency inside of a class that depends on it, this is called **tight coupling** and it makes unit testing impossible.
- **Tight coupling** is when we create an object inside of a dependent class.
- **Dependency**: An object that another class depends on.
- Should inject the object into the class.
- Achieve **loose coupling** with **dependency injection**!.

```java
@Controller
public class GradeController {
    GradeService gradeService = new GradeService(); // bad
    // presentation layer...
}
```

### Dependency Injection Process

1. First annotate the class using `@Component`.
2. Spring Boot registers `@Component` class as a bean.
3. `@Autowired` injects the bean into the dependent class.

```java
// Controller
@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;
}

// Service
@Component
public class GradeService {

    @Autowired
    GradeRepository gradeRepository;
}

// Repository
@Component
public class GradeRepository {}
```

## `@Service` and `@Repository`

- `@Component` is too generic.
- Use `@Service` and `@Repository` instead.
- `@Service`, `@Repository` and `@Component` are all the same.
  - Any of them will turn a class into a bean.
- Good Practice:
  - Use `@Service` for the business logic layer.
  - Use `@Repository` for the data access layer.

```java
// Service
@Service
public class GradeService {

    @Autowired
    GradeRepository gradeRepository;
}

// Repository
@Repository
public class GradeRepository {}
```

## How to register a bean? `@Bean`

- `@Component` and `@Component` derivatives (`@Service`, `@Repository`)
- Register a bean with `@Bean`.

1. Create a Bean definition.
2. `@Configuration` marks the class as a source of `@Bean` definitions.
3. `@Autowired` wires the bean into the class that needs it.

```java
// Created a new file AppConfig.java
@Configuration
public class AppConfig {

  @Bean
  public GradeRepository gradeRepository() {
    return new GradeRepository();
  }
}

// Deleted this and used the @Component inside
// GradeRepository.java instead because it is sufficient.
// This @Bean is just to learn "good-to-know" stuff, might need it next time.
```
