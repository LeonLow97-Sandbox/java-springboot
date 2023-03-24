# Guide on Setting Up SpringBoot

1. In VSCode, `CTRL + SHIFT + P` --> Spring Initializr: Create a Maven Project
2. Select java version (get this from terminal by running `java -version`).
3. Fill in other details

- Group Id: Identifies the organization (eg. com.ltp)
- Artifact Id: Name of the application (eg. hello-spring)
- Choose JAR as the file packaging type.
- Dependency: Software that the application depends on.

4. Inside `pom.xml`, add the following dependencies (downloaded from [Central Maven Repository](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)):

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

5. Change the server port of SpringBoot

- In `application.properties`, add `server.port=9090`.

6. Maven SpringBoot run
  - `./mvnw clean spring-boot:run`
    - removes previously compiled code and runs it
  - `./mvnw spring-boot:run`
    - compiles the application's code and runs it.
  - `Spring Boot DevTools`
    - similar to nodemon.
