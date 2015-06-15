package test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import test.model.Person;


@Repository
public class PersonRepository {

	
	   @Autowired
	   MongoTemplate mongoTemplate;
	 
	   public void save(Person person) {
	      mongoTemplate.save(person);
	   }
	   
	   public void save(List<Person> persons) {
	      mongoTemplate.save(persons);
	   }

	   public Person get(String id) {
	      return mongoTemplate.findById(id, Person.class);
	   }
	   
	   public List<Person> getAll() {
	      return mongoTemplate.findAll(Person.class);
	   }
	   
	   public void delete(Person person) {
	      mongoTemplate.remove(person);
	   }
}
