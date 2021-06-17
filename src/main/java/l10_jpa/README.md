We are creating data using jps with h2 as db

setting our db using application.properties. paste the following code:

---

logging.level.org.springframework = info
#This is not really needed as this is the default after 2.0.0.RELEASE
spring.jackson.serialization.write-dates-as-timestamps=false
spring.messages.basename=messages

!if u wanna set your own port number
!server.port=8084

management.endpoints.web.exposure.include=\*
spring.security.user.name=username
spring.security.user.password=password
#log the sql in the log whenever a statement is executed
spring.jpa.show-sql=true
#use h2
spring.h2.console.enabled=true
#url used in the browser to access h2
spring.datasource.url=jdbc:h2:mem:shah
spring.data.jpa.repositories.bootstrap-mode=default

---

adding our data by adding it into data.sql:

---

insert into user values(10001, sysdate(), 'AB');
insert into user values(10002, sysdate(), 'Jill');
insert into user values(10003, sysdate(), 'Jam');
insert into post values(11001, 'My First Post', 10001);
insert into post values(11002, 'My Second Post', 10001);

---

once all done, go to browser, http://localhost:8085/h2-console

with the following input:

JDBC URL = jdbc:h2:mem:shah
