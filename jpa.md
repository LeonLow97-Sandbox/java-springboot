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

```java
// Repository Interface
@Repository
public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {

    @Query(value = "SELECT * FROM my_entity WHERE my_field = :fieldValue", nativeQuery = true)
    List<MyEntity> findByFieldValue(String fieldValue);

}

// Repository Class
@Repository
public class MyRepository {

    private final JdbcOperations jdbcOperations;

    public MyRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public List<MyEntity> findByFieldValue(String fieldValue) {
        String sql = "SELECT * FROM my_entity WHERE my_field = ?";
        return jdbcOperations.query(sql, new Object[]{fieldValue}, new MyEntityRowMapper());
    }
}

```