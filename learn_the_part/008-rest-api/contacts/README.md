# REST API

- API: mediates the interaction of a 'consumer' and a system.
  - API reads consumer's request and it it is valid, it acts as a mediator by grabbing content from another system and produces a response.
- REST API: API that conforms to a set of guidelines.
  - **Resource**: piece of data that you can name. (e.g., movies, products, employees)
  - URI: Identifies the location of a resource (consumer has to specify the URI)
  - Defines operations that can manipulate resources: GET, POST, PUT, DELETE
  - The resource is most often represented using JSON.
  - Serailize the data in JSON before sending it back.
  - **Collection**: grouping of resources (request all resources)
- [CheatSheet](https://www.learnthepart.com/course/af54547f-e993-47bd-ad51-d7c7270c4e50/71bb9319-32e7-481a-98e6-2ec9897ee257)

# REST Operations

- GET: retrieves a resource.
- POST: creates a resource.
- PUT: updates a resource.
- DELETE: deletes a resource.

# Annotations

|    Annotation     |                             Description                             |
| :---------------: | :-----------------------------------------------------------------: |
|  `@RequestParam`  |              Used in the past to extract query values.              |
|  `@PathVariable`  | Used recently to extract data from **URI**. More suitable for REST. |
|  `@ResponseBody`  |                   Serializes an object into JSON.                   |
|  `@RequestBody`   |                   Deserialize JSON into an object                   |
| `@RestController` |                   `@Controller` + `@ResponseBody`                   |
| `@ResponseEntity` |                    Returns data and status code.                    |

# Annotations for Exception Handling

|     Annotation      |                                   Description                                   |
| :-----------------: | :-----------------------------------------------------------------------------: |
| `@ControllerAdvice` | class-level annotation that allows you to define **global exception handlers**. |
| `@ExceptionHandler` |           method-level annotation that defines an exception handler.            |
|    `JsonFormat`     |                      Configure the serialized JSON format.                      |

```java
@ExceptionHandler(YourException.class)
public ReturnType method(YourException ex) {}
```

## OpenAPI REST API Documentation

- Path for one of the operations, as well as a description of what it does.
- Parameters to be included for the operation to succeed.
- The response to expect if the client makes a good request.

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-ui</artifactId>
  <version>1.6.9</version>
</dependency>
```

- [API Docs](http://localhost:8080/v3/api-docs)
- [View OpenAPI Definition](http://localhost:8080/swagger-ui/index.html)

## OpenAPI Annotations

|Annotation|Description|
|:-:|:-:|
|`@ApiResponse`|This annotation is used to specify a possible response from an API operation. It takes parameters such as response code, description, and schema.|
|`@ApiResponses`|This annotation is used to specify a list of possible responses from an API operation. It takes an array of `@ApiResponse` annotations as its parameter.|
|`@Operation`|This annotation is used to describe an API operation. It takes parameters such as HTTP method, operation summary, description, request body, and response type. This annotation can also be used to specify parameters and security requirements for the operation.|