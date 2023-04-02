# SQL Database (Spring Boot JPA)

- H2: Provides an in-memory relational database.
  - all data will be lost whenever we restart application.
  - fast and lightweight.
- JPA: allows us to interact with the database
  - connects to a object relational mapping database.

```java
// application.properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2
spring.datasource.url=jdbc:h2:mem:grade-submission
```

## Object Relational Mapping

- ORM: Creates an object oriented layer between the application and an SQL database.

### Creating a Table in ORM

1. Set up a student `@Entity` in a POJO class.

- `@Table(name = "student")`: to specify table name

2. Each `@Entity` field maps to a table column.

- `@Column`: maps each field to a column
  ```java
  @Id // assign primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto generation (increment) of id
  @Column(name = "id")
  private Long id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "birth_date", nullable = false)
  private LocalDate birthDate;
  ```

3. The primary key column uniquely identifies each record inside the table.

### Saving Data (INSERT) in ORM

1. Spring JPA provides a `CrudRepository`.

- Have to create an interface that extends the `CrudRepository`.
  - An object will be created from this implementation and it will exist inside of the spring container as a bean.
  - This repository b ean will inherit all of the methods that the `CrudRepository` exposes like `save`, `findById`, `existsById`.

2. Make a POST request with payload that consists of JSON.
3. Can save the entity (Java Object) from the `CrudRepository`.

# Lombok

- Java library used to minimise or remove the boilerplate code. Saves time nd effort.
- Just by using the annotations, save space and readability of the source code.
- Download `Lombok Annotations Support` extension on VSCode.
  - `import lombok.*;`

```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <scope>provided</scope>
</dependency>
```

## Lombok Annotations

|     Lombok Annotation      |                                    Description                                    |
| :------------------------: | :-------------------------------------------------------------------------------: |
|         `@Getter`          |                   Generates getters for all non-static fields.                    |
|         `@Setter`          |                   Generates setters for all non-static fields.                    |
|   `@AllArgsConstructor`    |              Generates a constructor with arguments for all fields.               |
|    `@NoArgsConstructor`    |                    Generates a constructor with no arguments.                     |
|    `@EqualsAndHashCode`    |    Generates equals() and hashCode() methods based on the fields of the class.    |
| `@RequiredArgsConstructor` | Generates a constructor for all final fields in a class. Takes `@NonNull` fields. |
|       `@JsonIgnore`        |                            Remove as part of the JSON.                            |

- If there are no constructors, Java generates one by default.
- If a constructor is defined, don't forget to add `@NoArgsConstructor`.

# Table Relationships

## Unidirectional Relationship

- **Many** rows in the child table belong to **One** row in the parent table.
- Foreign key: references the primary key of another table.
- Process:

  1. Many grades are associated with One student.
  2. The child table manages the foreign key.

  ```java
  // Tells Spring JPA that many grades are associated to one student
  public class Grade {
    @ManyToOne(optional = false) // a grade cannot exist without a student
    @JoinColumn(name = "student_id", referencedColumnName = "id") // define a foreign key column that joins 2 separate tables
    private Student student;
  }
  ```

- `optional = false` vs `nullable = false`
  - `optional = false` is a runtime instruction which happens before contacting the database. (recommended)
  - `nullable = false` blocks the null value at the database layer.

## Defining a Custom Query

```java
public interface GradeRepository extends CrudRepository<Grade, Long> {
  // Custom query
  Grade findByStudentId(Long studentId);
}
```

## Bidirectional Relationship

- One to Many Relationship
- On the parent side, we say there is a OneToMany relationship. On the child side, we say there is a ManyToOne relationship.
- The owner who is managing the relationship is the **foreign key column**.
  - Thus, on the other table, need to put a `mappedBy` parameter.
  - `mappedBy`: goes on the non-owning side of the relationship.
- Rule of thumb: When applicable, put the foreign key column in the table that cannot live without the other.

## Cascade

- If we were to delete a student, grades associated with that student_id will have no meaning at all. Have to cascade down the effect of deleting the student.
- Only works for Bidirectional.

```java
@JsonIgnore
@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
private List<Grade> grades;
```

## `Autowired` vs `@AllArgsConstructor`

- Udemy instructor suggests that `@AllArgsConstructor` should be used when there are too many beans to inject.
  - Don't have to specify multiple `@Autowired` annotations.
- ChatGPT suggests that `@AllArgsConstructor` is not the best choice as the number of dependencies injected into a bean increases.
  - It makes it difficult to keep track of which argument corresponds to which field.
  - Harder to debug and modify the code, and it can also make it more error-prone.

```java
@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    GradeRepository gradeRepository;
    StudentRepository studentRepository;
```

## `Optional`

- More elegant way for dealing with 'null' values passed into the controller.
  - For example, updating a student that does not exist.
- Prevents `NullPointerExceptions`.
- Container around an object that risks being 'null'.
- Tells whoever is using the method that null might be returned so the user must handle it.

```java
@Override
public Student getStudent(Long id) {
    Optional<Student> student = studentRepository.findById(id);
    if (student.isPresent()) {
        return student.get();
    } else {
        throw new StudentNotFoundException(id);
    }
}
```

## `@Transactional`

- `@Transactional` annotation is used to specify that the method should be executed within a transaction.

```java
@Transactional
void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
```

- In this case, the method "deleteByStudentIdAndCourseId" is performing a database operation (delete) which requires a transaction to ensure data consistency and integrity.

## `@UniqueConstraint`

- Adding unique constraints to multiple columns.

```java
@Table(name = "grade", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"student_id", "course_id"})
})
```

- Adding unique constraint to a single column.

```java
@NonNull
@Column(name = "code", nullable = false, unique = true)
private String code;
```
