# F1 Results API
Simple API Code Example for consume F1 historical results using Spring Boot - PostgreSQL - Mockito

![CC0 Public Domain](https://www.publicdomainpictures.net/pictures/300000/velka/max-verstappen-f1.jpg)

# Steps to install

## 1.- Install all dependences
* Java 8
* PostgreSQL Server

## 2.- Clone this repo

## 3.- Import DB Script on psql
```
\i 'PROJECT_PATH/datasets/completed/F1_DB_Backup.sql'
```

## 4.- Init Spring Boot
```
.\mvnw.cmd spring-boot:run
```

# [Demo Swagger](http://afdev.ddns.net/swagger-ui.html#/results-controller)

## ToDO
* Mockito Unit testing
* CI/CD

## Resources
* [Datasets](https://hasura.io/docs/latest/schema/postgres/postgres-guides/import-data-from-csv/)

* [Spring Initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.7.9&packaging=war&jvmVersion=1.8&groupId=com.apex&artifactId=demo&name=demo&description=F1%20API%20using%20GraphQL%20-%20Spring%20Boot%20-%20Mockito&packageName=com.apex.demo&dependencies=web,data-jpa,postgresql,graphql)




