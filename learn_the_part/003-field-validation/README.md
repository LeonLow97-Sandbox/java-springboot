# Field Validation

1. Annotate the fields that need validation

```java
@Min(18)
private Integer age;
```

2. Pass in a bad input
3. `@Valid` can validate the fields inside the handler method.

- Spring Boot creates an empty object to receive POST request
- uses setters to update the fields in the object from the POST request

4. A `BindingResult` carries the result of the validation.
5. A negative `BindingResult` forces the user to stay in the form.
6. Thymeleaf catches the error and displays them.

```java
// Setup
// BindingResult must come after the object (where object is validated)
@PostMapping("/handleSubmit")
public String submitForm(@Valid Grade grade, BindingResult result) {
    if (result.hasErrors())
        return "form";

// In POJO Object
@NotBlank(message = "Name cannot be blank")
private String name;
@NotBlank(message = "Subject cannot be blank")
private String subject;

// Thymeleaf template
<p style="color:red" th:errors="*{name}"></p>
<p style="color:red" th:errors="*{subject}"></p>
```
