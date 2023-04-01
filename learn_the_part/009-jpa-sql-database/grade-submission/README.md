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