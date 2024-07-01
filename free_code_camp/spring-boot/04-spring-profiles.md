# Spring Profiles

- Provides ways to separate application configuration and make it available only it certain environment (dev and prod).
- Some beans are only available in specific environments (dev, staging or prod).
- Only when profile is active, the bean will be active.

## Create Profile specific property

- Create a new file under `resources` called `application-dev.properties` and this file will only be available in `dev` environment.
- Set Active profile to `dev`

- Setting profiles in `application.properties`
	- Will see this in CLI The following 1 profile is active: "dev"

```yaml
# application.properties
spring.profiles.active=dev

my.custom.property=Hello Leon in prod environment
my.custom.property.int=123

# application-dev.properties (spring will load these because profile is `dev`)
my.custom.property=Hello Leon in dev environment
my.custom.property.int=321
```

- Can also specify multiple environments
	- Will see this in CLI: The following 3 profiles are active: "dev", "test", "staging"
- If defined as `dev,test,custom`, order matters! It will load dev properties first, then override with test properties, then override with custom properties.

```yaml
# application.properties
spring.profiles.active=dev,test,custom
```

- Setting properties to be read programmatically.

```java
@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(ExampleApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "test"));
			
		// ctx is context of our application
		var ctx = app.run(args);
	}
}
```

## Utilise beans for a specific environment / profile

- Setting specific bean on bean level with `@Profile` with `dev` profile

```java
@Configuration
public class ApplicationConfig {
	@Bean("bean1")
	@Profile("dev")
	public MyFirstClass myFirstClass() {
		return new MyFirstClass("My First Bean");
	}

	@Bean
	@Profile("test")
	public MyFirstClass mySecondBean() {
		return new MyFirstClass("My Second Bean");
	}

	@Bean
	// @Primary
	public MyFirstClass myThirdBean() {
		return new MyFirstClass("My Third Bean");
	}
}
```

- Setting beans to class level with `@Profile` with `dev` profile

```java
@Configuration
@Profile("dev")
public class ApplicationConfig {
	@Bean("bean1")
	public MyFirstClass myFirstClass() {
		return new MyFirstClass("My First Bean");
	}

	@Bean
	public MyFirstClass mySecondBean() {
		return new MyFirstClass("My Second Bean");
	}

	@Bean
	// @Primary
	public MyFirstClass myThirdBean() {
		return new MyFirstClass("My Third Bean");
	}
}
```