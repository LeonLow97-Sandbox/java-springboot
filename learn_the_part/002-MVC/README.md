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
    - sends model to the view
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

- Responds to requests by combining the Model and View.
- `GET Request`: user is requesting a resource.
  - localhost:8080/grades
  - host:port/path

## Model

- Model is data that the Controller sends to the View.
- Without a Model, the View is meaningless.
- Process:

  1. the handler method has direct access to the Model.
  2. the handler method can create data in the form of objects.

     - contains _private fields, constructors and getters/setters_

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

- Variable expression `${...}`: Executes on a _model_ attribute in some way.
- Selection expression `*{field}`: Selects a _field_ from a previously bound object.
  - `th:object="${model_object}"`

```java
<tr th:object="${grade}">
  <td th:text="*{name}"</td>
  <td th:text="*{subject}"</td>
  <td th:text="*{score}"</td>
</tr>
```

### Thymeleaf conditionals

- `th:if`: renders an element if a condition is true.
- `th:unless`: renders an element if a condition is false.
- ternary operator returns a value based on a condition.
- `th:switch`: renders the matching case `th:case`.

### Thymeleaf Utility Methods

- A variable expression can execute a utility method on a model attribute.
- There are utility methods for `arrays, calendars, dates, lists, maps, numbers, objects, sets, strings` and etc.
- Syntax: `"${#strings.method(target, args)}"`
  - e.g., `"${#strings.contains(target, '123')}"` returns true or false
- [Link for utility methods](https://github.com/thymeleaf/thymeleaf/tree/3.1-master/lib/thymeleaf/src/main/java/org/thymeleaf/expression)

### Thymeleaf Expressions

|     Expressions      | Representation |                   Description                   |
| :------------------: | :------------: | :---------------------------------------------: |
| Variable Expression  |    `${...}`    |   Executes on a model attribute in some way.    |
| Selection Expression |   `*{field}`   | Selects a field from a previously bound object. |
|   Link Expression    |     `@{/}`     |       URL endpoint or path to a resource.       |

### CSS Style

- Linking to CSS Stylesheet using Thymeleaf: `<link th:href="@{/grades-stylesheet.css}" rel="stylesheet">`

### Variable Expression

- Return a model attribute or a value that derives from it.
- Execute a condition based on a model attribute.
- Execute a loop based on a model attribute.
- Execute a utility method on a model attribute.

### Thymeleaf Loop

```html
<tr th:each="grade: ${grades}">
  <td th:text="${grade.name}" </td>
  <td th:text="${grade.subject}" </td>
  <td th:text="${grade.score}" </td>
</tr>
```

### Form Submission

- Make sure we have the getters and setters in the object
- Spring Boot uses the publically available setters to receive incoming data from POST requests.
  - POST Request Payload: `field`
  - Corresponding Setter: `setField`

```html
<form method="post" th:object="${grade}" th:action="@{/handleSubmit}">
  <input type="text" placeholder="Name" th:field="*{name}" />
  <input type="text" placeholder="Score" th:field="*{score}" />
  <input type="text" placeholder="Subject" th:field="*{subject}" />
  <br /><br />
  <input type="submit" value="Submit" />
</form>
```

### Redirect

```java
@PostMapping("/handleSubmit")
public String submitForm(Grade grade) {
    studentGrades.add(grade);
    return "redirect:/grades";
}
```

# CheatSheet

- [HTML CheatSheet](https://www.learnthepart.com/course/af54547f-e993-47bd-ad51-d7c7270c4e50/66ac8b6d-8195-410c-853f-29df93a84aef)
- [MVC CheatSheet](https://www.learnthepart.com/course/af54547f-e993-47bd-ad51-d7c7270c4e50/9996e227-3402-4553-9009-dfbdbe1d5d64)
