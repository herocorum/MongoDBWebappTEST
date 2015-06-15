package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.dao.PersonDAO;
import test.dao.SequenceDaoImpl;
import test.model.Person;

@Service
public class PersonSerfice {
//	  @Autowired private SequenceDaoImpl sequenceDao;
	  @Autowired private PersonDAO personDAO;
	  
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
