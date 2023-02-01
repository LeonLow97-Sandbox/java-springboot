# Creating a project

- Group Id: Identifies the organization (ex: com.ltp).
- Artifact Id: Name of the application (ex: hello-spring).
- Choose JAR as the file packaging type.
- Dependency: Software that your application depends on.

## Areas in Spring Boot Project

- Source Code
    - Entry point for all application logic
- Resources
    - includes static folder which contains images, css and html files.
    - includes template folder for html templates
    - application.properties for application settings
- Application Tests
    - for testing the application

## Maven springboot run

- `./mvnw spring-boot:run`
- `mvn spring-boot:run`
    - if you have maven installed
- Compile application's code.
- Runs the compiled code.

## Maven clean springboot run

- `./mvnw clean spring-boot:run`
- `mvn clean spring-boot:run`
    - if you have maven installed.
- removes previously compiled code
- compiles code and runs it.
















