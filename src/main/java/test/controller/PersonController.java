package test.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import test.model.Person;
import test.service.PersonServiceImpl;
import test.servlets.VerifyRecaptcha;



@RestController
@RequestMapping("/mypath")

public class PersonController {
    
    @Autowired private PersonServiceImpl personSerfice;

    @Autowired private ApplicationContext ctx;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    
    /**
     * @param model
     * @return
     *  GET ALL PERSON
     */
    
//    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
//    public String getAll(ModelMap model) {
//        model.addAttribute("users", personSerfice.getAll());
//        return "listUser";
//    }
    
    
    @RequestMapping(method = RequestMethod.GET,value="/getAll")
	public ModelAndView goToHelloPage() {
		ModelAndView view = new ModelAndView();
 
		view.addObject("users", personSerfice.getAll()); //adding of str object as 'message' parameter
		view.setViewName("listUser");
		return view;
	}
    
    
    
    /**
     * 
     * @param request
     * @param response
     * @throws IOException
     * 
     * CREATE PERSON
     */
    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public @ResponseBody
    void savePerson( HttpServletRequest request,HttpServletResponse response) throws IOException {

    	String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        
        System.out.println(gRecaptchaResponse);
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
    	
        String fname = request.getParameter("name");
        String lname =request.getParameter("surName");
        String cellPhone = request.getParameter("gsmNo");
        
        if(verify){

        	if(fname !=null && fname !=""  &&
        	   lname !=null && lname !=""){
			   
			   	  
				 Person person = ctx.getBean(Person.class);
				 Person tempPerson = ctx.getBean(Person.class);
        		
        		person.setName(fname);
        		person.setSurName(lname);
                person.setGsmNO(cellPhone);
                
                personSerfice.add(person);
                personSerfice.get(person.getId());
                
                tempPerson= personSerfice.get(person.getId());
        		
                if(tempPerson.getId().equals(person.getId())){
                	
                    LOGGER.debug("successfully created ");
                    response.getWriter().print("Successfull");
                }else{
                    LOGGER.debug("creation failed ");
                    response.getWriter().print("failed");
                }
        	}else{
        		LOGGER.debug("creation failed ");
        		response.getWriter().print("failed");
        	}
        }else{
        	LOGGER.debug("creation failed ");
        	response.getWriter().print("failed");
        }
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws IOException
     * 
     * UPDATE  PERSON
     */
    @RequestMapping(method = RequestMethod.GET, value = "/update")
    public @ResponseBody
    void updatePerson(HttpServletRequest request,HttpServletResponse response) throws IOException {

    	
    	 String editUserId = request.getParameter("userId");
         String fname = request.getParameter("name");
         String lname =request.getParameter("surName");
         String cellPhone = request.getParameter("gsmNo");
         
		 		 
				
	     Person person = ctx.getBean(Person.class);
		 
         person =  personSerfice.get(Long.parseLong(String.valueOf(editUserId)));
		 
		 
         
         person.setName(fname);
         person.setSurName(lname);
         person.setGsmNO(cellPhone);
         
             
           try{
        	   personSerfice.update(person);
        	   LOGGER.debug("successfully updated ");
        	   response.getWriter().print("Successfull");
        	  
           }catch(Exception e){
        	   e.printStackTrace();
        	   LOGGER.debug("updating failed ");
        	   response.getWriter().print("failed");
        	   
           }
         
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public @ResponseBody
    void deletePerson( HttpServletRequest request,HttpServletResponse response) throws IOException {

    	 String editUserId = request.getParameter("userId");
         
		 
		 Person person = ctx.getBean(Person.class);
		 
    	 person.setId(Long.parseLong(String.valueOf(editUserId)));
    	 
    	 personSerfice.remove(person.getId());
    	 
    	 person =   personSerfice.get(person.getId());
         
         if(person==null){
       	  	  LOGGER.debug("successfully updated ");
        	  response.getWriter().print("Successfull");
         }else{
        	  LOGGER.debug("deleting failed ");
        	  response.getWriter().print("failed");
         }
    }
    
    
    
    
    
    
    
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/getPerson")
    public @ResponseBody
    void getPerson( HttpServletRequest request,HttpServletResponse response) throws IOException {

    	 String editUserId = request.getParameter("userId");
    	 String name = request.getParameter("name");
    	 String surname = request.getParameter("surname");
		 
		 Person person = ctx.getBean(Person.class);
		 
    	 person.setId(Long.parseLong(String.valueOf(editUserId)));
    	 
    	 person =   personSerfice.get(person.getId());
         
         if(person.getId().toString().equalsIgnoreCase(editUserId))
        	  response.getWriter().print("Successfull");
         else
        	  response.getWriter().print("failed");
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/getAllPerson")
    public @ResponseBody
    void getAllPerson( HttpServletRequest request,HttpServletResponse response) throws IOException {

    	List<Person> personList =personSerfice.getAll();
    	
        response.getWriter().print(personList.size());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}