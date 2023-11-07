# Getting Started

* Clone the code
* Go to the folder
 
> ./mvnw clean install

## Once build completes then execute 

> docker run -p 8080:8080  docker.io/agileguru/aleagraalcrud:main

## When Docker Runs Open Browser 

* [list mappings](http://localhost:8080/)
* [Create Records](http://localhost:8080/person/create) ( do this multiple times )
* [List Records](http://localhost:8080/persons)

## Update and Delete has not been implemented but should be straight forward 

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/#build-image)

