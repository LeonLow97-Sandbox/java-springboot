# Testing Web Application

## Dependency Injection and Unit Testing

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
- Use the annotation `@Test`