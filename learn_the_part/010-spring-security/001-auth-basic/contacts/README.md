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
    - base64 encoding simply ensures the *user:pass* characters are all ASCII (character set known to all computer systems). From our application, we can decode it back to plain text.
  3. **Authentication**: Spring Security validates the identity of the client against its records.
    - If no match, it sends back error code of *401*.
  4. **Authorization**: Spring Security determines what the client has access to.
    - Sends back error code of *403*.
    - E.g., client must have a role of admin. If role of user, not authorized to perform the action.
  