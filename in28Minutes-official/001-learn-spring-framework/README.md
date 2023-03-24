# Adding Components and Autowired

- `@Component` and `@Autowired`
- created a context in Spring application
  - `ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args);`
- using context to get bean from a class
  - `GameRunner runner = context.getBean(GameRunner.class);`

# How does Spring Framework identify the components and wire them together?

- Debug:

```
GameRunner runner = context.getBean(GameRunner.class);

Identified candidate component class: file [GameRunner.class]
Identified candidate component class: file [MarioGame.class]
Creating shared instance of singleton bean 'gameRunner'
Creating shared instance of singleton bean 'marioGame'
Autowiring by type from bean name 'gameRunner' via constructor to bean named 'marioGame'
```