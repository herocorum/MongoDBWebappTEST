package test.service;

import java.util.List;

import test.model.Person;

public interface PersonService {
	
	public void add (Person person);    
    public void update (Person person);
    public Person get (Long id);
    public List<Person> getAll ();
    public void remove (Long id);
}
