package l3_rest_controller;

import org.springframework.stereotype.Component;
/*
Qualifier: by default, obj created in container will have name using class name with small 
caps. but u can specify your own name. if u specify your own name (lap1 for this class), 
make sure any obj of this class created in other classes must included be renamed the same name: @Qualifier("lap1")


@Component // To enable singleton design pattern
//@Scope(value="prototype") //this will opp of singleton - will only create obj if getBeans is used

 */

// @Component("book1") - this is qualifier
public class Book {

	long id;
	String name;
	String author;

	public Book(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
