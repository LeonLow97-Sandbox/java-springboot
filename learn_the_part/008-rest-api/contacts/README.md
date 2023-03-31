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

# REST Operations

- GET: retrieves a resource.
- POST: creates a resource.
- PUT: updates a resource.
- DELETE: deletes a resource.

# Annotations

|Annotation|Description|
|:-:|:-:|
|`@RequestParam`|Used in the past to extract query values.|
|`@PathVariable`|Used recently to extract data from **URI**. More suitable for REST.|
|`@ResponseBody`|Serializes an object into JSON.|
|`@RestController`|`@Controller` + `@ResponseBody`|
|`@ResponseEntity`|Returns data and status code.|