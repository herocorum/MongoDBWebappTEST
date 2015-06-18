package testClasses;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.dao.PersonDAO;
import test.model.Person;

public class PersonDAOTest {
	
	
	private PersonDAO personDAO;


    @Before
    public void setUp() {
    	personDAO = mock(PersonDAO.class);
    
    }
	
    
    /**
     * person object defined null and
     * their field mocked as a null except gsmNo
     * whenever person object need to be persist in db 
     * NullPointerException should be thrown
     * 
     */
    @Test(expected = NullPointerException.class)
    public void createPerson() {
	   Person person =null;
	   
	   when(person.getId()).thenReturn(null);
	   when(person.getName()).thenReturn(null); 
	   when(person.getSurName()).thenReturn(null); 
	   when(person.getGsmNO()).thenReturn("0536-402-50-33"); 

	   when(personDAO.create(person)).thenThrow(new NullPointerException());

	   assertNull(person.getId());
       assertNull(person.getName());
       assertNull(person.getSurName());
       Assert.assertNotNull(person.getGsmNO());
	   
	   personDAO.create(person);
	   
    }
    
    
    
    @Test
    public void findPerson() {
	   Person model =new Person("testname","testlasname");
	   model.setId(1L);
	   
	   when(personDAO.get(model.getId())).thenReturn(model);  
       
	   Person returnedPerson = personDAO.get(model.getId());
	   
	   Assert.assertEquals(model.getId(),returnedPerson.getId());
	   Assert.assertEquals(model.getName(),returnedPerson.getName());
	   Assert.assertEquals(model.getSurName(),returnedPerson.getSurName());
	   Assert.assertNull(returnedPerson.getGsmNO());
	   
    }

    
    /**
     *  after person object updated if we call that object
     *  newPerson will be updated person object instance 
     *  so person object should be moved to newPerson object
     */
    
    @Test
    public void updatePerson() {
	   Person person =new Person("testname","testlasname");
	   person.setId(1L);
	   
	   Person newPerson =new Person("newName","newLastName");
	   newPerson.setId(2L);
	   
	   when(personDAO.get(person.getId())).thenReturn(newPerson);  

	    person = personDAO.get(person.getId());
	   
	   Assert.assertEquals(person.getId(),newPerson.getId());
	   Assert.assertEquals(person.getName(),newPerson.getName());
	   Assert.assertEquals(person.getSurName(),newPerson.getSurName());
	   Assert.assertNull(newPerson.getGsmNO());
	   
    }

    
    @Test
    public void getAllPerson() {
	   Person person =new Person("testname","testlasname");
	   Person person2 =new Person("name","lastname");
	   
	   when(personDAO.getAll()).thenReturn(Arrays.asList(person, person2));
	   
	  Assert.assertEquals(2, personDAO.getAll().size());
    }
    
    
    /**
     * after we removed person object if we call
     * somewhere that object it return null
     * and if we try to get some field of that
     * object we will face with NullPointerException
     * 
     */
    @Test(expected = NullPointerException.class)
    public void deletePerson()   {

        Person person = new Person();
        person.setId(1L);
        person.setName("name");
        person.setSurName("lastname");
        
 
        personDAO.remove(person.getId());  
        
        when(personDAO.get(person.getId())).thenReturn(null);  
         
        Person returnedPerson = personDAO.get(person.getId());

        Assert.assertNull(returnedPerson);
        Assert.assertNotNull(returnedPerson.getId());
        
    }
    
    
}
