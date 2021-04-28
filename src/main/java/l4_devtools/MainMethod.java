package l4_devtools;

/*
 * this lesson we will leearn about devtools
 * 
 * definition:
 * 
 * Provides fast application restarts, LiveReload, and 
 * configurations for enhanced development experience.
 * 
 * usually when u make changes to the application, u need
 * to stop and start the server to allow changes to take
 * effeect. but eith devtools, any changes in app is auto updated 
 * without having to restart server
 * simply add 1 dependency in pom: spring-boot-devtools
 * now try to change the values of book, save, and refresh browser.
 * itll auto update
 * 
 * stop & start server: 9sec
 * auto update: 2sec
 * 
 * this saves alot of time and effort
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainMethod {

	public static void main(String[] args) {
		SpringApplication.run(MainMethod.class, args);
	}

}
