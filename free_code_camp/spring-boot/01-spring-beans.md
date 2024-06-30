# Spring Beans

## Creating our First Bean

```java
@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		// ctx is context of our application
		var ctx = SpringApplication.run(ExampleApplication.class, args);

		MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
		System.out.println(myFirstClass.sayHello());
	}

	// Adding bean to Spring Context
	@Bean
	public MyFirstClass myFirstClass() {
		return new MyFirstClass();
	}

}
```

- Another way of using `@Component` to inject the Java Class as a Spring Bean.
  - Using `@Service`, `@Repository` also works because they extends the `@Component` annotation

```java
// In MyFirstClass.java file
@Component
public class MyFirstClass {
	public String sayHello() {
		return "Hello World!";
	}
}

// In ExampleApplication.java (main file)
@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		// ctx is context of our application
		var ctx = SpringApplication.run(ExampleApplication.class, args);

		MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
		System.out.println(myFirstClass.sayHello());
	}

	// @Bean // this is commented out now!
	public MyFirstClass myFirstClass() {
	return new MyFirstClass();
	}

}
```

- Another way is using `@Configuration` so Spring will scan this class for Spring Beans.

```java
@Configuration
public class ApplicationConfig {
	@Bean
	public MyFirstClass myFirstClass() {
		return new MyFirstClass();
	}
}
```

## Retrieving bean by name

```java
// specifying the bean name in `getBean`
MyFirstClass myFirstClass = ctx.getBean("myFirstClass", MyFirstClass.class);

// if specified wrong name, it will throw error
// Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'wrongName' available
MyFirstClass myFirstClass = ctx.getBean("wrongName", MyFirstClass.class);
```

- Defining Bean Name explicitly

```java
@Configuration
public class ApplicationConfig {
	@Bean("myBean")
	public MyFirstClass myFirstClass() {
		return new MyFirstClass();
	}
}

...
MyFirstClass myFirstClass = ctx.getBean("myBean", MyFirstClass.class);
```
