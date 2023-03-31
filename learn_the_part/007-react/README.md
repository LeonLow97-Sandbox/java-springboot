# Use React instead of Thymeleaf

- Thymeleaf and Spring Boot are within the same web application, this is an outdated practice and the frontend should be decoupled from the backend.
- React is a frontend JavaScript framework which decouples from the backend.
- Many frontend will make requests to the Backend
  - For example, React and Angular make requests to Spring Boot in web applications.
  - Kotlin and Flutter are used to make requests to Spring Boot in mobile applications.
- Response is in the form of JSON or XML

```java
// Controller
@RestController
@CrossOrigin(origins = "*") //Not to worry. These annotations will be covered in Module 2.
public class GradeController {

    List<Grade> list = Arrays.asList(
        new Grade("Harry", "Potions", "C-"),
        new Grade("Hermione", "Arithmancy", "A+"),
        new Grade("Neville", "Charms", "A-")
        );

    @GetMapping("/grades")
    public ResponseEntity<List<Grade>> getGrades() {
        return new ResponseEntity<List<Grade>>(list, HttpStatus.OK);
    }
}
```
