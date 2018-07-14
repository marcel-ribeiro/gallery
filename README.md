# Gallery App
Sample of an application that displays a list of pictures.
The pictures are stored with 3rd party provider that offers REST APIs to retrieve the pictures and it's details.
- Building: `mvn clean install`

This app is composed by 2 modules: **gallery-backend** and **gallery-frontend**.


##gallery-backend
Spring-boot microservice that consumes rest services from a 3rd party and exposes REST endpoints to be consumed by the UI (gallery-frontend) 
All the code for this microservice lives in the **gallery-backend** module.

The REST endpoints exposed by this module will be always preceeded by `/rest`, I.E.: http://localhost:8080/rest/

- Running: `mvn spring-boot:run`
- Access via REST client: `GET http://localhost:8080/rest/`

##gallery-frontend
Angular 5 app that provides a nice UI to visualize the pictures gallery

- Running: `npm run start`
