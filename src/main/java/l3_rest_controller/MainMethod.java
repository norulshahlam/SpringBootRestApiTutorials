package l3_rest_controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainMethod {

	public static void main(String[] args) {
		SpringApplication.run(MainMethod.class, args);

		/*
		 * from the above line, this is where spring will initialize the container and
		 * create ONE OBJECT of classes with @Component added to class so, even without
		 * specifying which class object, spring creates 1 obj pre hand by default w/o u
		 * calling it. this component is annoted in laptop & alien class so obj will be
		 * created of these class type. this is called singleton design pattern. u can
		 * test this by using constructor.
		 * 
		 * however, if u add @Scope(value="prototype") to the class, then only obj will
		 * b created only when you called it (getBean is used)
		 * 
		 * if it is prototype (not singleton), then below obj will be created twice cos
		 * u called it twice. else obj is creeated once. u can test this by using
		 * default constructor. if below code is removed, still obj is created bocs of
		 * singleton design pattern.
		 */
	}

}
