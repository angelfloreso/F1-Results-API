# ApexSpringMockito
Code Example - F1 API using GraphQL - Spring Boot - Mockito

# https://start.spring.io/
https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.0.2&packaging=war&jvmVersion=1.8&groupId=com.apex&artifactId=demo&name=demo&description=F1%20API%20using%20GraphQL%20-%20Spring%20Boot%20-%20Mockito&packageName=com.apex.demo&dependencies=web,data-jpa,postgresql,graphql

# Bio
https://morioh.com/p/dba5cdf1ddd5
# Datasets
https://ergast.com/mrd/db/
https://hasura.io/docs/latest/schema/postgres/postgres-guides/import-data-from-csv/

# To import

\copy <table_name> from '</path/to/file/filename.csv>' delimiter ',' CSV HEADER;

# for example
\copy profile from '/Users/sarahlewis/documents/profile.csv' delimiter ',' CSV HEADER;


# for create database
CREATE DATABASE f1_db;
CREATE USER f1_user WITH PASSWORD 'a912072';
GRANT ALL ON DATABASE "f1_db" to "f1_user";
GRANT SELECT ON "f1_user" TO PUBLIC
GRANT USAGE, CREATE ON SCHEMA public TO "f1_user";




# for init
mvnw spring-boot:run

