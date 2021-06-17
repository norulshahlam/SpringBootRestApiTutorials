### Content negotiation

https://www.udemy.com/course/spring-web-services-tutorial/learn/lecture/7591346#content

process of selecting one of multiple possible representations to return to a client, based on client or server preferences. ...

run this on postman:
GET localhost:8080/users

we will get result in json. but what if we want to get it in xml? run this again.

this time set you Headers to Accept = application/xml.

we will get status 406. So what it's saying is the requested resource is only capable of generating content according to the accept headers sent in the request. What it's saying is this XML is not a valid accept header.

How to solve? All that we need to do is to add dependencies in our pom.xml -

<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml -->
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
    <version>2.12.1</version>
</dependency>

With this dependency, we can do the same for POST request

this time set you Headers to Content-type = application/xml. This is for sending POST request having a body. we sent the body in xml this time.

POST localhost:8080/create

body:

 <item>
        <name>redsgredgd</name>
        <birthDate>2021-06-17T07:12:10.377+00:00</birthDate>
    </item>

both works fine.
