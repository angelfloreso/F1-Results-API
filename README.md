# F1 Results API 
![CC0 Public Domain](https://www.publicdomainpictures.net/pictures/300000/velka/max-verstappen-f1.jpg)
![Coverage](.github/badges/jacoco.svg)
![Test](https://github.com/afv9988/F1-Results-API/actions/workflows/flow.yaml/badge.svg)

This is a simple API Code Example for consume F1 historical results 
- Features
  - Spring Boot
  - Swagger
  - PostgreSQL
  - Mockito
  - JWT *
  - JaCoCo *
  - GitHub Actions *
  - Badges updated *

# Steps to install

## 1.- Install all dependences
* Java 8
* PostgreSQL Server 
* Maven

## 2.- Clone this repo
```
git clone https://github.com/afv9988/F1-Results-API.git
mvn clean install
```

## 3.- Import DB Script on psql
* Execute import script or you can use my instance
```
\i 'PROJECT_PATH/datasets/completed/F1_DB_Backup.sql'
```

## 4.- Init Spring Boot
```
.\mvnw.cmd spring-boot:run
```

# [Demo Swagger](http://afdev.ddns.net/swagger-ui.html#/results-controller)

### For access the Demo you need to generate a token 
### http://afdev.ddns.net/token?password=PASSWORD&username=USER
### Then authenticate in Swager on JWT apiKey
### For external use of token add -H "Authorization: YOUR-TOKEN-GENERATED"

## ToDO
* Improve Code Coverage

## Resources
* [Datasets](https://hasura.io/docs/latest/schema/postgres/postgres-guides/import-data-from-csv/)

* [Spring Initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.7.9&packaging=war&jvmVersion=1.8&groupId=com.apex&artifactId=demo&name=demo&description=F1%20API%20using%20GraphQL%20-%20Spring%20Boot%20-%20Mockito&packageName=com.apex.demo&dependencies=web,data-jpa,postgresql,graphql)




