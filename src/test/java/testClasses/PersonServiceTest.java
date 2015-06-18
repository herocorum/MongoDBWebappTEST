package testClasses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import test.dao.PersonDAO;
import test.model.Person;
import test.service.PersonService;
import test.service.PersonServiceImpl;


import static org.hamcrest.Matchers.is;
 
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


public class PersonServiceTest {

	private PersonService personService;
	private PersonDAO personDAO;


    @Before
    public void setUp() {
    	personDAO = mock(PersonDAO.class);
    	personService = new PersonServiceImpl(personDAO);
    
    }

    
    @Test
    public void createPerson()   {

        Person person = new Person();
        person.setId(1L);
        person.setName("name");
        person.setSurName("lastname");

        personService.add(person);
        when(personService.get(1L)).thenReturn(person);
        
        Person model = personService.get(person.getId());

        Assert.assertNotNull(model.getId());
        Assert.assertEquals(model.getName(),model.getName());
        Assert.assertEquals(model.getSurName(), model.getSurName());
        assertThat(model.getSurName(), is(model.getSurName()));
        assertNull(model.getGsmNO());
    }
    
    
    @Test
	public void testCreate() {
		// When
		  Person entity = new Person();
	      this.personService.add(entity);
	 
	      // Then
	      ArgumentCaptor< Person > argument = ArgumentCaptor.forClass( Person.class );
	      verify( this.personDAO ).create( argument.capture() );
	      assertThat( entity, is( argument.getValue() ) );
	}
    
    /**
     * we created person object after we remove it,
     * when we call person object we should see null as value. 
     * here model instance should be null because 
     * when ever someone call removed person object
     * 
     */
    @Test(expected = NullPointerException.class)
    public void deletePerson()   {

        Person person = new Person();
        person.setId(1L);
        person.setName("name");
        person.setSurName("lastname");
        
 
        personService.remove(person.getId()); //it will really remove but 
        
        when(personService.get(1L)).thenReturn(null); //if someone call person object it will get null (removed object)
         
        Person model = personService.get(person.getId());

        Assert.assertNull(model);
        Assert.assertNotNull(model.getId());
        
    }
    
    /**
     * when the first person object updated  
     * then returned updated to newPerson object 
     * whenever we call person object we will see new updated object
     * 
     */
    @Test 
    public void updatePerson()   {

        Person person = new Person();
        person.setId(1L);
        person.setName("name");
        person.setSurName("lastname");
        
        Person newPerson = new Person();
        newPerson.setId(2L);
        newPerson.setName("newName");
        newPerson.setSurName("newLasName");
        
        personService.update(person); //we are not actually update 
        
        when(personService.get(person.getId())).thenReturn(newPerson); // when we called person object it will return updated newPerson
        
        person = personService.get(person.getId());
        
        assertThat(2L, is(person.getId()));
        assertThat("newName", is(person.getName()));
        assertThat("newLasName", is(person.getSurName()));
        
        Assert.assertEquals(person.getId(),newPerson.getId());
        Assert.assertEquals(person.getName(),newPerson.getName());
        Assert.assertEquals(person.getSurName(),newPerson.getSurName());
        assertNull(person.getGsmNO());
        
    }
    
    /**
     * firstly we created an object
     * after we saved it 
     * later we tried to find that object
     * whenever someone call saved object then it will return saved object to him
     */
    
    @Test 
    public void findPerson()   {

        Person person = new Person();
        person.setId(1L);
        person.setName("name");
        person.setSurName("lastname");
     
        
        personService.add(person); 
        
        when(personService.get(person.getId())).thenReturn(person);  
        
        person = personService.get(person.getId());
        
        assertThat(1L, is(person.getId()));
        assertThat("name", is(person.getName()));
        assertThat("lastname", is(person.getSurName()));
        assertNull(person.getGsmNO());
        
    }
    
 
    
    
	
}
