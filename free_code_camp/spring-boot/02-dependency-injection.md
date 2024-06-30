## Dependency Injection

- Constructor Injection

```java
@Service
public class MyFirstService {

	private final MyFirstClass myFirstClass;

	public MyFirstService(MyFirstClass myFirstClass) {
		this.myFirstClass = myFirstClass;
	}

	public String tellStory() {
		return "Bean saying: " + myFirstClass.sayHello();
	}
}

```

- Using `@Qualifier` to inject specific bean that returns the same type.

```java
@Configuration
public class ApplicationConfig {
	@Bean
	@Qualifier("bean1")
	public MyFirstClass myFirstClass() {
		return new MyFirstClass("My First Bean");
	}

	@Bean
	@Qualifier("bean2")
	public MyFirstClass mySecondBean() {
		return new MyFirstClass("My Second Bean");
	}
}

// Service
	public MyFirstService(@Qualifier("bean2") MyFirstClass myFirstClass) {
		this.myFirstClass = myFirstClass;
	}
```

- Using `@Primary` to make bean have the highest priority.

```java
@Configuration
public class ApplicationConfig {
	@Bean
	public MyFirstClass myFirstClass() {
		return new MyFirstClass("My First Bean");
	}

	@Bean
	public MyFirstClass mySecondBean() {
		return new MyFirstClass("My Second Bean");
	}

	@Bean
	@Primary // highest priority bean
	public MyFirstClass myThirdBean() {
		return new MyFirstClass("My Third Bean");
	}
}
```

- Using Field injection for dependency injection. Add `@Autowired` and can remove constructor.
- NOT RECOMMENDED. always use constructor injection or setter injection.

```java
// NOT RECOMMENDED
@Service
public class MyFirstService {

	@Autowired
	private MyFirstClass myFirstClass;

	public String tellStory() {
		return "Bean saying: " + myFirstClass.sayHello();
	}
}
```

- Setter Injection
  - Method name starts with `set...`

```java
@Service
public class MyFirstService {

	private MyFirstClass myFirstClass;

	@Autowired
	public void setMyFirstClass(@Qualifier("myThirdBean") MyFirstClass myFirstClass) {
		this.myFirstClass = myFirstClass;
	}

	public String tellStory() {
		return "Bean saying: " + myFirstClass.sayHello();
	}
}
```
