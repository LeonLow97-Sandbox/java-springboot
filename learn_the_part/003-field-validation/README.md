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

// Thymeleaf template (to display error message)
<p style="color:red" th:errors="*{name}"></p>
<p style="color:red" th:errors="*{subject}"></p>
```

## Custom Constraints

1. Define an annotation using `@interface`.
2. Connect the annotation to validation logic.

#### Defining the annotation

1. Name of your annotation
2. Target
    - annotation of method? field?
3. Retention

```java
// In Score.java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ScoreValidator.class)
public @interface Score {
  
  String message() default "Invalid Data"; // default error message
  Class<?>[] groups() default {}; // always include this for annotation
  Class<? extends Payload>[] payload() default{}; // always include this for annotation

}

// In ScoreValidator.java
public class ScoreValidator implements ConstraintValidator<Score, String> {
  
  List<String> scores = Arrays.asList(
    "A+", "A", "A-",
    "B+", "B", "B-",
    "C+", "C", "C-",
    "D+", "D", "D-",
    "F"
  );

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    for (String string: scores) {
      if (value.equals(string)) return true;
    }
    return false;
  }

}

// In POJO Grade.java
@Score(message = "Score must be a letter grade")
private String score;
```
