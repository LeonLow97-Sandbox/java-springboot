# Basic Authentication

- **Authentication**: verifies the identify of a client.
- **Authorization**: determines what they have access to.

## HTTP Request

- Contains a header and a body
- Header contains Authorization. Body contains payload to create, update, delete resources, ...
- Process:
  1. The API requires authentication before processing a client's request.
  2. The client's HTTP request needs to include credentials in the header.
  - the credentials are base64 encoded.
  - base64 encoding simply ensures the _user:pass_ characters are all ASCII (character set known to all computer systems). From our application, we can decode it back to plain text.
  3. **Authentication**: Spring Security validates the identity of the client against its records.
  - If no match, it sends back error code of _401_.
  4. **Authorization**: Spring Security determines what the client has access to.
  - Sends back error code of _403_.
  - E.g., client must have a role of admin. If role of user, not authorized to perform the action.

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

### Security Filter Chain

- `SecurityFilerChain`: Bean that describes a chain of security rules (filters).
- `UserDetailsService`: Bean contains User details.
  - Basic Auth depends on this information to authenticate users.

- Example of Security Filter Chain
  1. Delete /contact/{id} requires authentication
  2. Only admins have the authority to invoke Delete /contact/{id}
  3. Post /contact requires authentication
  4. admins and users have the authority to invoke Post /contact
  5. Get operations can be accessed by anybody.

### BCrypt

- Hashing Algorithm for password protection.

```java
@Bean
public BCryptPasswordEncoder bCryptPasswordEncoder() {
  return new BCryptPasswordEncoder();
}
```

### CSRF

- Attack against browsers.
