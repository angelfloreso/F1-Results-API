# ApexSpringMockito
Code Example - F1 API using GraphQL - Spring Boot - Mockito

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
postgres=# CREATE DATABASE f1_db;
postgres=# CREATE USER f1_user WITH PASSWORD 'a912072';
postgres=# GRANT ALL PRIVILEGES ON DATABASE "f1_db" to f1_user;

