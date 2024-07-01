# Special Beans

## Environment Bean

- Helps us to read environment variables and also reading command line arguments.

```java
// Environment Bean
@Service
public class MyFirstService {

	private MyFirstClass myFirstClass;
	private Environment environment;

	@Autowired
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String getJavaVersion() {
		return environment.getProperty("java.version");
	}

	public String getOSName() {
		return environment.getProperty("os.name");
	}
}

// In Main
@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		// ctx is context of our application
		var ctx = SpringApplication.run(ExampleApplication.class, args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellStory());
		System.out.println(myFirstService.getJavaVersion()); // 17.0.5
		System.out.println(myFirstService.getOSName()); // Mac OS X
	}
}
```

- Adding property in application.properties and reading with environment bean

```java
// application.properties
my.custom.property=Hello Leon Low Environment

// MyFirstService.java
public String readProperty() {
	return environment.getProperty("my.custom.property");
}

// Main
System.out.println(myFirstService.readProperty());
```

- Reading properties from custom file like `custom.properties`
- Use `@PropertySource`

```java
@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {

	private final MyFirstClass myFirstClass;

	@Value("${my.prop}")
	private String customPropertyFromAnotherFile;

	public String getCustomPropertyFromAnotherFile() {
		return this.customPropertyFromAnotherFile;
	}
}
```

- Reading properties from multiple custom files
- Use `@PropertySources`

```java
@Service
@PropertySources({
	@PropertySource("classpath:custom.properties")
	@PropertySource("classpath:custom-file-2.properties")
})
```

- Injecting property from `application.properties` into Java type.
- Use `@Value`

```java
// Service
@Value("${my.custom.property}")
private String customProperty; // can also be Integer if your property is integer

public String getCustomProperty() {
	return this.customProperty;
}

// Main
System.out.println(myFirstService.getCustomProperty());
```
