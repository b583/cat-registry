# Cat Registry
Small Dropwizard application done to illustrate some ideas on how to handle Java 9 modules.

## Running the application

Create a database Docker container:
```shell
docker run --name cat-registry-psql -p 30000:5432 -d -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=catregistry postgres:14.5
```

Setup the schema:

```shell
docker exec -it cat-registry-psql psql -U postgres catregistry
```

```roomsql
CREATE SCHEMA cat;

CREATE TABLE cat.cat (
id SERIAL NOT NULL,
name TEXT NOT NULL,
color TEXT NOT NULL,
is_nice BOOLEAN NOT NULL,
PRIMARY KEY (id)
);
```

Create a *config.yaml* file with following contents:
```yaml
service:
  shouldRegisterNotNiceCats: false
database:
  driverClass: org.postgresql.Driver
  user: postgres
  password: password
  url: jdbc:postgresql://localhost:30000/catregistry
  properties:
    charSet: UTF-8
    hibernate.dialect: org.hibernate.dialect.PostgreSQLDialect
  maxWaitForConnection: 1s
  minSize: 8
  maxSize: 32
  checkConnectionWhileIdle: false
```
Start CatRegistryMainApplication with arguments
``server config.yaml``.