# Unit Testing REST APIs

- [Code Link](https://www.youtube.com/watch?v=pNiRNRgi5Ws&ab_channel=DanVega)
- Process of coding and running unit tests for REST controllers.
- Ensure APIs process requests and produce responses as expected:
    - If a request contains invalid data --> return status 400 Bad Request.
    - If a request contains valid data --> return status 200 OK
    - Response has expected status and content type.
    - Response headers include expected key and value.
    - JSON document in response body has expected fields and values.
- Test only code of controller layer.

## Annotations

- `@WebMvcTest`:
    - Disable full auto-configuration
    - Apply only configurations for MVC tests (e.g., REST controllers)
    - `@Service`, `@Component`, `@Repository` components will not be loaded
- ObjectMapper
    - Serialize a Java object (entity class/DTO) to a JSON document.
    - Deserialize a JSON document to a Java object.
- Mockito APIs:
    - Create mock objects of service components used by REST controllers.
    - Mock objects in arguments and return statement of service methods.
    - Verify if a service method gets called.
- MockMvc:
    - Perform requests (API calls)
        - GET, POST, DELETE, PUT
    - Assert the response (status code, content type, JSON document, ...)

## Technologies

- Java Spring Framework
- Spring Data JPA & Hibernate
- Spring Web MVC
- Spring Test
- JUnit
- Mockito
- ModelMapper
- Jarkarta Bean Validation
- MySQL JDBC Driver

## Software Programs

- Java Development Kit (JDK)
- Spring Tool Suite IDE
- MySQL Database Server
- MySQL Workbench
- Postman Desktop