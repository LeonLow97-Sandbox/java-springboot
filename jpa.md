# What is JPA?

- JPA (Java Persistence API) is a Java specification that provides a standard way of mapping Java objects to relational databases.
- It is a higher-level abstraction that provides an object-relational mapping (ORM) solution, allowing you to work with databases using Java objects rather than writing SQL queries directly.

## Benefits of using JPA

1. Increased Productivity
  - JPA allows you to work with databases using Java objects, which can be more intuitive and easier to work with than writing SQL queries directly. 
  - Saves time and increases productivity.
2. Database Independence
  - JPA provides a level of abstraction between Java code and the database, allowing you to switch between different database systems (such as PostgreSQL, MySQL, or Oracle) without having to change your code.
3. Type Safety
  - JPA allows you to work with database using Java objects, which provides a level of type safety that is not available when working with SQL queries directly.
4. Query Abstraction
  - JPA provides a query language (JPQL) that is similar to SQL, but provides additional features such as object-oriented querying, type-safe querying and caching.
  - Easier to write and maintain complex queries.

## Writing SQL Queries with JPA 

- `SELECT`

```java
// Repository Interface
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    
    @Query("SELECT e FROM EmployeeEntity e JOIN e.department d WHERE d.name = :departmentName")
    List<EmployeeEntity> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);
    
}

List<EmployeeEntity> employees = employeeRepository.findEmployeesByDepartmentName("Sales");
```

- `UPDATE`, `INSERT`, `DELETE`

```java
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    
    @Modifying
    @Query("UPDATE EmployeeEntity e SET e.firstName = :firstName, e.lastName = :lastName WHERE e.id = :id")
    void updateEmployeeName(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastName") String lastName);
    
}
```