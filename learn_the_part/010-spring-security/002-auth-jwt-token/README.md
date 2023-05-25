# Roadmap

- Secure API using Basic Authentication (not recommended).
- Connect application to MySQL Database.
- Secure API using Token-based Authentication (JWT Token).

## Token-Based Authentication

- More secure than Basic Authentication, recommended approach!
- Passing a JSON Web Token.

## Json Web Token (JWT Token)

- NEVER store sensitive data inside payload or header.
  - can be easily decoded by anyone.
- Consists of a **Header, Payload and a Signature**
  - The _header_ is metadata that describes the type of token that's being sent.
    - E.g., JWT and also includes the algorithm it used to secure it like HS256.
    - header is `base64 encoded`.
  - The _payload_ is relevant data to the user
    - E.g., subject that stores client's username, name field that stores their name.
    - The more data you include in your payload, the bigger the JWT.
    - Never store sensitive data in the payload, can be easily decoded by anyone.
    - Payload is also `base64 encoded`.
  - The signing algorithm produces a digital _signature_ that combines the header, the body and a secret key that nobody knows about except for the API.
    - Impossible to decode (depending on the difficulty of your secret key).
    - If the user tries to tamper with the payload, the API has the secret key and it will produce the digital signature which is not the same as the signature being sent in the tampered JWT Token. Thus, the user/request is not authenticated. `Invalid token with status code 403!`
- When a user logs in successfully, we will send them back a signed JSON Web Token and the user can make authenticated requests.
- As a request is made, the API will combine the header and the payload using the secret key to produce the digital signature. The API compares this digital signature with the digital signature provided in the JWT Token in the request. If it matches, then the user is authorized as they are using a valid token.

## Security Filter Chain

- Pathway 1: Signing Up
  - User is signing up.
  - There is a security rule for this that permits all requests on the path register without the need to authenticate.
  - Request is executed and credentials are saved.
- Pathway 2: Authentication
  - If credentials match what we have with the records, the user will be granted a JWT Token.
  - `Authorization: Bearer JWT`
- Pathway 3: JWT Authorization
  - Given the access token, user can use the token as evidence that they have been authenticated.
  - We need to ensure that the token provided is valid before authorizing the users to make a request.
  - The user can use this token to make requests.
  - Set authentication on `SecurityContextHolder`.

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

## `SecurityContextHolder`

- Once the validation process passes, then the API is going to set the authentication on the security context holder.
- It is where Spring Security stores who has been authenticated.
- User has been successfully authenticated and we can follow up with their request.

## No authentication required for SignUp

```java
.andMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll() // not requiring authentication
```

## Pathway 2: Authentication

- User sends POST request to backend with `username` and `password`.
- Authentication Filter
  - Request gets passed to the `attemptAuthentication()` function to create an `Authentication` object.
- Authentication Manager
  - The request then gets passed to the `authenticate()` function where the username and password are compared with that in the database.
- Authentication Filter
  - If authenticated, create JWT in the method of `successfulAuthentication()` in the `header.payload.signature`.

