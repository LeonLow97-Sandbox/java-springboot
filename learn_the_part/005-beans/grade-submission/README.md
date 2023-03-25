# Beans and Dependency Injection

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