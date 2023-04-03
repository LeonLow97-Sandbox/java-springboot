# Token-Based Authentication

- More secure than Basic Authentication, recommended approach!
- Passing a JSON Web Token.

## Pathways

- Pathway 1: Signing Up
  - User is signing up.
  - There is a security rule for this that permits all requests on the path register without the need to authenticate.
  - Request is executed and credentials are saved.
- Pathway 2: Logging In
  - If credentials match what we have with the records, the user will be granted a JWT Token.
- Pathway 3: Authorization
  - Given the access token, user can use the token as evidence that they have been authenticated. 
  - We need to ensure that the token provided is valid before authorizing the users to make a request.
  - The user can use this token to make requests

## Json Web Token (JWT Token)

- NEVER store sensitive data inside payload or header.
  - can be easily decoded by anyone.
- Consists of a **Header, Payload and a Signature**
  - The *header* is metadata that describes the type of token that's being sent.
    - E.g., JWT and also includes the algorithm it used to secure it like HS256.
    - header is base64 encoded.
  - The *payload* is relevant data to the user
    - E.g., subject that stores client's username, name field that stores their name.
    - The more data you include in your payload, the bigger the JWT.
    - Payload is also base64 encoded.
  - The signing algorithm produces a digital *signature* that combines the header, the body and a secret key that nobody knows about except for the API.
    - Impossible to decode (depending on the difficulty of your secret key).
- When a user logs in successfully, we will send them back a signed JSON Web Token.
- As a request is made, the API will combine the header and the payload using the secret key to produce the digital signature. The API compares this digital signature with the digital signature provided in the JWT Token in the request. If it matches, then the user is authorized as they are using a valid token.

```json
// Header
{
  "alg": "HS256",
  "typ": "JWT"
}

// Payload
{
  "sub": "leonlow97",
  "name": "Leon Low",
  "exp": 920834544
}
```

# `SecurityContextHolder`

- Once the validation process passes, then the API is going to set the authentication on the security context holder.
- It is where Spring Security stores who has been authenticated.