# Testing Web Application

- [CheatSheet](https://www.learnthepart.com/course/af54547f-e993-47bd-ad51-d7c7270c4e50/b1d2354a-aa5c-4621-828a-3c2ea80f49fd)

## Dependency Injection and Unit Testing

- **Unit Test**: Check if one small unit of your app works.

### What should we unit test?

- The **Service** that contains business logic.
- Business logic is vulnerable to bugs.
- Cannot unit test the **Service** when it's tightly coupled.
- `ServiceTest` must test `Service` in complete isolation.
- Loose Coupling
  - The class does not create a dependency.
  - Spring injects a bean into the variable.
  - During testing, spring boot is not running so the bean variable is null.
  - As the service class is loosely coupled, inject a mock into the variable instead. The mock can mimic the behavior of a dependency, but it doesn't have any logic of its own.
- Using a mock can test the `Service` in isolation.
- Unit Testing reduces the possibility of getting bugs.
- Use the annotation `@Test`

### Setting Up Unit Testing

1. Create a class called `GradeServiceTest.java`
2. `@RunWith` uses `MockitoJUnitRunner` to run every unit test.

```xml
<!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

3. Use `@Mock` to create a mock of the Repository.

- this allows the `GradeService` to run test in isolation.

4. `@InjectMocks` creates an object and injects the mock into it.

- Injects `GradeRepository` into `GradeService` object.
- Creates a real object out of `GradeService`, and then it injects the `GradeRepository` mock into it.

### Process of Unit Testing

- `@Test` tells JUnit to run the method as a test.
- 3 steps to writing unit test:
  1. **Arrange**: Mock the data needed to carry out the unit test.
  2. **Act**: Call the method that you want to test.
  3. **Assert**: Check if the method if behaving correctly.
- `verify(mock, times).method();`
  1. The mock.
  2. Number of times you expect its method to be invoked.
  3. The method.

# Integration Test

- **Integration Test**: Maps the request and response lifecycle.
- Traverses the entire application.
- Require the _Spring Container_ with Integration Testing.
- Unit testing comes before integration test.
- Verify the interaction between components in the application.
- `@SpringBootTest` scans the entire application for components and loads them as beans.
- `AutoConfigureMockMvc`: can mock web requests against one of the controllers handler methods.
  - To test how the application handles web requests without running or deploying the application.
