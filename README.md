# Getting Started

This is a simple (Java) Javalin application. It is a RESTful API that facilitate money transfers between accounts:
- The API is invoked during test by different Thread to represent requests from different systems.


##### Application Requirements:
- Java 8
- Maven 3+

##### Application Run:
Step One:
> Building:
```
~$ mvn clean package
```
Step Two:
> Running :
```
~$ java -jar target/rev-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Once the application is up, the application documentation can be accessed via

`~:7002/swagger-ui`

It contains details about each insight endpoints exposed.

### Assumptions
> Ports available
- 7002

### Reference Documentation
For further reference, how the RESTAPI is consumed please visit the documentation home page

* [Official Rev Bank documentation](~:7002/swagger-ui)

###   Regards!
