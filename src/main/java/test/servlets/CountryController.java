package test.servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import test.model.Person;
import test.service.PersonSerfice;


/*
 * Note: The POST method for create Country is on the ContinentController.
 * This keeps the URLs in the @RequestMapping consistent.
 */

@RestController
public class CountryController {
    
    @Autowired private PersonSerfice personSerfice;
    
  
    
 
    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
    public String getListReader(ModelMap model) {
        model.addAttribute("users", personSerfice.getAll());
        return "listUser";
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/saveEntity")
    public @ResponseBody
    void saveEntity( HttpServletRequest request) {

        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        String action = request.getParameter("action");
        String gsmNo = request.getParameter("gsmNo");

       

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