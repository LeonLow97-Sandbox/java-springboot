# Spring REST

- REST = Representational State Transfer
- Client-Server Architecture, client and server should act independently
- Stateless
	- Server does not store any information of the HTTP request
- Cache-able
	- prevent client from using outdated data
- Layered System
- Uniform Interface (decouples architecture, allows each section to scale independently)
- Unique Identification of Resources (URI)

## Resource Design

- The resource should always be **plural nouns** in the API endpoint and if one instance resource is be retrieved, pass the `id` in the URL:
	- `GET /accounts`
	- `GET /accounts/1`
	- `DELETE /accounts/2`
- In case of nested resources (resources under a resource), the resources should be accessible as follows:
	- `GET /accounts/1/payments/56`

## `@ResponseStatus`

- To specify the response status of a controller method, annotate method with `@ResponseStatus`
- Spring only uses `@ResponseStatus` when the marked method completes successfully (without throwing an Exception).