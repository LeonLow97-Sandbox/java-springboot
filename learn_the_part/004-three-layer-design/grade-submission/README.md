# Three Layer Design

- Layer 1: Presentation
- Layer 2: Business Logic
- Layer 3: Data Access

## CRUD

- Create Read Update Delete data.
- CRUD operations must be inside `Repository`.
- The Repository class is the Data Access Layer.
- Controller class (Presentation layer)
  - The Controller class (presentation) does not communicate directly with data access layer.
  - Updates the model using data from the data access layer.
  - Updates view based on data in the model.
  - Controller manages the model and presenting the view.
- Service class (Business Logic Layer)
  - The service class is the middleman between the presentation and the data access layer.
  - The service class is the business logic layer because it contains every business related operation.
- Data Access Layer (Data Access Layer)
  - Passes data back to the controller class.
- In a nutshell, the controller class calls the service class, and the service class calls the repository class.
