### What Is Spring?

Simply put, the Spring framework provides comprehensive infrastructure support for developing Java applications.

It's packed with some nice features like Dependency Injection and out of the box modules like:

Spring JDBC
Spring MVC
Spring Security
Spring AOP
Spring ORM
Spring Test

### What Is Spring Boot?

Spring Boot is basically an extension of the Spring framework which eliminated
the boilerplate configurations required for setting up a Spring application.
Spring boot is in btwn user and framework. Spring boot will give u the jar and config .
It is a production-ready application with jar and configurations done.
it has embedded server and db so user can run everything within the application without having to add external server/db

#### learning points

convert response into json format by default by using crudRepository
configure postman to accept only json/xml (under header > key & value
add support for xml result in postman by adding dependencies in pom. once this is done, then
response in browser will display xml only. to display back json, remove this dependencies
understand content negotiation: what type of data you want to produce or consume. It may be JSON or XML.
For configuring content negotiation, we need to add a dependency in pom.xml.
@RequestMapping: restrict response to only 1 format eg xml. else will return error
add new data using postman using form data and raw:
form data: key and values is given and u will enter key as col name and value as its values
raw: use text to add data with formatting. if format is in json, change from text to application/json
produces: send data from server to client. consume: when server accepting data from client.
Understanding CRUD (create, read, update, and delete) as the four basic functions of persistent storage.

Operation SQL HTTP RESTful WS DDS MongoDB
Create INSERT PUT/POST POST write Insert
Read (Retrieve) SELECT GET GET read/take Find
Update (Modify) UPDATE PUT/POST/PATCH PUT write Update
Delete (Destroy) DELETE DELETE DELETE dispose Remove

@RestController insteadof @Controller: all method will be working for rest &
so dont need to mention @ResponseBody in every method
@Produes: restrict to using one type of format when sending CRUD requests
@RequestBody: use this in post method to enable u to use raw data to add data in postman
