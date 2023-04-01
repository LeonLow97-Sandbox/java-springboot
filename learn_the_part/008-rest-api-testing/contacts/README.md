# Writing Integration Tests

## Mocking POST Request

- Use `ObjectMapper` to convert any POJO to JSON.
  - Purpose is to send a JSON.

```java
@Autowired
private ObjectMapper objectMapper;
```
