# MVC Design

- Spring Boot applications follow the MVC design.
- View: what the user sees (server sends back html to the user). Visual elements that make up a webpage.
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
  - Handler method returns a view.

## Controller

- Responds to requests be combining the Model and View.
- `GET Request`: user is requesting a resource.
  - localhost:8080/grades
  - host:port/path

## Model

- Model is data that the Controller sends to the View.
- Without a Model, the View is meaningless.
- Process:
  1. the handler method has direct access to the Model.
  2. the handler method can create data in the form of objects.


      - contains *private fields, constructors and getters/setters*
  3. the handler method can store the data in a Model attribute.


      - Model attribute maps to a piece of data.
      - `model.addAttribute("name", data);`
- Every handler has access to the model.

## Thymeleaf

- Combines View and Model
- Uses variable expression that executes on a model attribute
  - e.g., th:text="${grade.name}"

```java
<td th:text="${grade.name}"</td>
<td th:text="${grade.subject}"</td>
<td th:text="${grade.score}"</td>
```

### Thymeleaf expressions

- Variable expression `${...}`: Executes on a model attribute in some way.
- Selection expression `*{field}`: Selects a field from a previously bound object.
  - `th:object="${model object}"`

```java
<tr th:object="${grade}">
  <td th:text="*{name}"</td>
  <td th:text="*{subject}"</td>
  <td th:text="*{score}"</td>
</tr>
```
