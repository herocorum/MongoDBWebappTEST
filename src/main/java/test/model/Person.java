package test.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
//@Document(collection = Person.COLLECTION_NAME)
public class Person {
	
	public static final String COLLECTION_NAME = "persons";

	 @Id
	private  Long  Id;
	private  String name;
	private  String surName;
	private  String gsmNO;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, String surName) {//long id, 
//		Id = id;
		this.name = name;
		this.surName = surName;
	}

 
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurName() {
		return surName;
	}


	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getGsmNO() {
		return gsmNO;
	}
	public void setGsmNO(String gsmNO) {
		this.gsmNO = gsmNO;
	}
 
 
 
}