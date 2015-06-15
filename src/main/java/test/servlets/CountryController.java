package test.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.model.Person;
import test.service.PersonSerfice;


/*
 * Note: The POST method for create Country is on the ContinentController.
 * This keeps the URLs in the @RequestMapping consistent.
 */

@RestController
@RequestMapping(value="/country")
public class CountryController {
    
    @Autowired private PersonSerfice personSerfice;
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        
        if ((name == null || name.equals("")) || (surName == null || surName.equals(""))) {
            request.setAttribute("error", "Mandatory Parameters Missing");
        } else {
            Person p = new Person();
            p.setSurName(surName);
            p.setName(name);
            
         
        }
    }
    
	@RequestMapping("/person")
	public Person getPersonDetail(@Valid @RequestBody Person person) {//@RequestParam(value = "id", required = false, defaultValue = "0") Integer id
		
		
//		Person p = personRepositoryImpl.getPersonDetail(id);
		return null;
	}
    
    
//    @RequestMapping(value="/{name}", method=RequestMethod.GET)
//    public Person getCountry(@PathVariable("name") String countryId) {     
//    	Person country = countryConverter.convert(countryId);
//        return country;
//    }
    
    
    
//    @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
//    public ResponseEntity<Person> createContinent(@Valid @RequestBody Person continent) {
//    	Person savedPerson = personRepositoryImpl.save(continent);
//
//        URI uri = ServletUriComponentsBuilder
//                    .fromCurrentRequest()
//                    .pathSegment("{id}")
//                    .build()
//                    .expand(savedPerson.getId())
//                    .toUri();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(uri);
//        
//        return new ResponseEntity<Person>(headers, HttpStatus.CREATED);
//    }
    
    
}