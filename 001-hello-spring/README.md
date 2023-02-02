# Creating a project

- `CTRL + SHIFT + P` -> Spring Initializr: Create a Maven Project -> Select java version (based on `java -version`)
- Group Id: Identifies the organization (ex: com.ltp).
- Artifact Id: Name of the application (ex: hello-spring).
- Choose JAR as the file packaging type.
- Dependency: Software that your application depends on.
- Add Spring Web Dependency in `pom.xml`
- [See full steps here](https://www.learnthepart.com/course/af54547f-e993-47bd-ad51-d7c7270c4e50/fadc9aa8-24dc-41fd-b8ee-1a4c55e32205)

## Running Spring Boot with `Jar` file

- [JAR File](https://www.learnthepart.com/course/af54547f-e993-47bd-ad51-d7c7270c4e50/9383b899-fcc5-4943-8874-89d36476396e)

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

## Client-Server Model

- Client (browser) makes a HTTP request via the internet.
- Server receives the request and responds.
- HTTP Server is the software that processes the request
- Spring Boot applications have an embedded HTTP Server
  - The embedded HTTP Server processes requests.

## IP Address

- Sequence of numbers that identifies a computer (server).
- Every computer has a unique IP Address.
- The server that matches the client's IP Address picks up the request.
- **Port**: Tells the server where to forward the request.
  - a server can have over 65,000 ports.
  - The HTTP server listens for requests on one of them.
  - e.g., 123.4.5.6:8080
  - DNS server maps the URL to an IP Address.
    - e.g., 172.217.13.132:443 --> www.google.com

## Launching a HTTP Server

- Add a dependency called **Spring Web**
  - Launches a HTTP Server
- **Dependency**: Packaged library of files (i.e. JAR files)
- Spring Web bootstraps an HTTP Server.
- Dependencies are found inside `pom.xml` file.
- **Central Maven Repository** contains downloadable dependencies
  - [Central Maven Repository](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)

## Localhost (Loopback address)

- Loopback address: 127.0.0.1:8080
  - Loops the request back to your own computer.
- `localhost:8080`
  - `localhost` translates to `127.0.0.1`

## Changing the server port

- In `application.properties` add:
  - `server.port=9090`

## Maven Dependencies

### Central Maven Repository

- Where maven downloads dependencies from.

### Local Maven Repository

- Once downloaded, Maven puts them in your local repository (your computer).
- If local repo doesn't contain the necessary dependencies, maven downloads them from the central maven repository.
- To access local repository
  - CTRL + SHIFT + G
  - `~/.m2/repository`

## Spring Boot DevTools Dependency

#### Running a Spring Boot app:

1. `clean spring-boot:run`: Runs application from scratch.
2. `Spring Boot DevTools`: Picks up new changes and restarts application. (it's like nodemon in nodejs)
   - download the dependency from central maven repository.
   - https://search.maven.org/artifact/org.springframework.boot/spring-boot-devtools/3.0.2/jar

## Cheatsheet

- [Cheatsheet](https://www.learnthepart.com/course/af54547f-e993-47bd-ad51-d7c7270c4e50/7899da2b-131f-4caa-b3b3-96bc0888aca8)
