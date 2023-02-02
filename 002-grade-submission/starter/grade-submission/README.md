# MVC Design

- Spring Boot applications follow the MVC design.
- View: what the user sees (server sends back html to the user).
- Model: data needed by the view
- Controller: glues the Model and View together.

```
----- Controller -----
getGrades():
    - fetches data
    - stores data in model
    - seconds model to the view
    - returns view
```

## Annotations

- `@Controller`: converts a class into a controller
    - class becomes the entry point for web requests.
- `@GetMapping`
    - Each handler method can respond to a request.
    - Converts a method into a handler method
    - The handler method can accept GET requests.

## Controller

- Responds to requests be combining the Model and View.
- `GET Request`: user is requesting a resource.
    - localhost:8080/grades
    - host:port/path






















