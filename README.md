# Gallery App
Sample of an application that displays a list of pictures.
The pictures are stored with 3rd party provider that offers REST APIs to retrieve the pictures and it's details.

- Pre-requisites:
    - Maven: [Install Maven](https://maven.apache.org/install.html)
    - Java 8
- Building: `mvn clean install`

This app is composed by 2 modules: **gallery-backend** and **gallery-frontend**.


##gallery-backend
Spring-boot microservice that consumes rest services from a 3rd party and exposes REST endpoints to be consumed by the UI (gallery-frontend) 
All the code for this microservice lives in the **gallery-backend** module.

The REST endpoints exposed by this module will be always preceeded by `/rest`, 
and the proper API documentation is available via [Swagger UI](http://localhost:8080/rest/swagger-ui.html)

- Running:  `cd gallery-backend` && `mvn spring-boot:run`
- REST API documentation: [Swagger UI](http://localhost:8080/rest/swagger-ui.html)

##gallery-frontend
Angular 6 app that provides a nice UI to visualize the pictures gallery

- Pre-requisites:
    - NodeJs: [Install NodeJs](https://nodejs.org/en/download/)
    - Angular cli: `npm install -g @angular/cli`
- Building: `cd gallery-frontend` &&  `npm i` && `npm run build`
- Running: `npm start`

