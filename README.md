# Books Register Application

## Prequisities:

#### Using `docker`:

* Docker

#### In native environment:

* Java 17
* PostgreSQL 14

## Configuration:

* Files can be found in `src/main/resources` directory
    * Edit `application.docker.properties` if running app using `docker`
    * Edit `application.properties` if running app natively

## Running:

#### Using `docker`:

* Navigate to project root directory
* Run `docker compose up`
* Wait until everything has started up
* Open `http://localhost:8080/swagger-ui/index.html` in your browser

#### Natively:

* Create database called `booksreg`
* Make sure that database user, that is defined in configuration, exists
* Run `./gradlew bootRun` in project root directory
* Open `http://localhost:8080/swagger-ui/index.html` in your browser
