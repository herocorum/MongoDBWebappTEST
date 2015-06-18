package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.dao.PersonDAO;
import test.model.Person;


@Service
public class PersonServiceImpl implements PersonService {
	
	  @Autowired private PersonDAO personDAO;
	  
	@Autowired
	public PersonServiceImpl(PersonDAO personDAO) {
	  this.personDAO=personDAO;
	}
	  
	public void add (Person person) {
		
        personDAO.create (person);
    }
    
    public void update (Person person) {
    	personDAO.update (person);
    }
    
    public Person get (Long id) {
        return personDAO.get(id);
    }
    
    public List<Person> getAll () {
        return personDAO.getAll ();
    }
    
    public void remove (Long id) {
    	personDAO.remove (id);
    }
}
