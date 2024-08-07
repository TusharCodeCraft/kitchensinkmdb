# Kitchensinkmdb 

Kitchensinkmdb is a Spring boot application. It is part of Modernization factory to migrate legacy JBoss Java application. 
Legacy application is a Jakarta EE 10 application using JSF, CDI, JAX-RS, EJB, JPA, and Bean Validation.

## Requirements

For building and running the application you need:

- [Java 21](https://www.oracle.com/uk/java/technologies/downloads/#java21)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `org.jboss.as.quickstarts.kitchensink.KitchensinkmdbApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:


```shell
mvn spring-boot:run
```
Once the application runs you should see something like this

```
2024-08-01T20:32:29.245+01:00  INFO 7672 --- [kitchensinkmdb] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/kitchensinkmdb'
2024-08-01T20:32:29.256+01:00  INFO 7672 --- [kitchensinkmdb] [           main] o.j.a.q.k.KitchensinkmdbApplication      : Started KitchensinkmdbApplication in 15.624 seconds (process running for 16.324)

```

You can build the project and run the tests by running
```shell
mvn clean package -DskipTests
```


Browser URL:
```
http://localhost:8080/kitchensinkmdb/index.jsf
```

Setup local instance of MongoDB. 
Update the MongoDB URL in `src/main/resources/application.properties` and `src/test/resources/application.properties` file as per your database configuration.

```
spring.data.mongodb.uri=mongodb://localhost:27017/kitchensink-db
```


## Migration approach 
1. Analyzed the POM file of legacy application to understand the tech stack.
2. Started spring boot project using [Spring Initializer](https://start.spring.io/)
3. Copied the content from `src\main\java`, `src\main\resources`, and `src\main\webapp`folder from legacy application to new Spring boot maven application.
4. Copied the content from `src\test\java` and `src\test\resources` from legacy application to new Spring boot maven application.
5. Updated `pom.xml` in the new project by refering the legacy application. 
6. Fixed the errors shown in IDE. 
7. Test the application. 