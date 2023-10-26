
# Quarkus App Template

- it's an intro for creating web services with quarkus
- check out also the related project 
  [spring-app-template](https://github.com/coc-university/spring-app-template)
- it provides the same functionality, just with spring boot
- in this way you can compare them

## Differences Quarkus vs. Spring Boot:

### General

- quarkus maybe needs a few more explicit dependencies in pom.xml (less starters)
- application.properties by default (extra dependency needed for yaml)
- no parent pom, but bom instead
- no explicit main class required (will be generated)
- three default profiles available (test, dev, prod)
- automatic hot reload, no extra dev tools required
- other annotations for loading config params into java beans

### API

- other annotations (@GET + @Path vs @GetMapping)
- explicit @Produces should be used to avoid wrong type
- [annotation comparison]https://quarkus.io/guides/spring-web#conversion-table
- check that resteasy dependency has jackson on board
- otherwise the controller can not convert the java object

### Business

- other annotation for bean definition (@ApplicationScoped vs @Service)
- other annotation for constructor injection (@Inject vs @Autowired), both optional

### DB

- other annotation for bean definition (@ApplicationScoped vs @Repository)
- PanacheRepository instead of CrudRepository
- Hibernate and Liquibase are used the same way, only adjust the keys in app props
- entities are exactly the same in quarkus and spring

### Testing

- no slice testing annotations (I guess), mostly @QuarkusTest
- mocking with mockito und testing with junit/rest-assured/etc. is the same

## Migration Doku

- [Link 1](https://marcelkliemannel.com/articles/2021/migrating-from-spring-to-quarkus/)
- [Link 2](https://dev.to/rmarting/lessons-learned-migrating-spring-boot-to-quarkus-1ccb)
