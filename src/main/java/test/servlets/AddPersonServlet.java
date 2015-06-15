package test.servlets;
 
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mongodb.DBCollection;

import test.AppConfig;
import test.model.Person;
import test.service.PersonSerfice;

 
@WebServlet("/addPerson3")
public class AddPersonServlet extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 60948240650978848L;
	
	
//	@Resource
//	@Qualifier("personRepositoryImpl")
//       PersonRepositoryImpl personRepositoryImpl;
    
//     private PersonSerfice personSerfice =new PersonSerfice();
//     private Person person =new Person();
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        
        if ((name == null || name.equals("")) || (surName == null || surName.equals(""))) {
            request.setAttribute("error", "Mandatory Parameters Missing");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/persons.jsp");
            rd.forward(request, response);
        } else {
        	//xml servletxml i varsa
//        	PersonSerfice personSerfice = (PersonSerfice) WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext()).getBean("personSerfice");

          AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
           
          PersonSerfice personRepositoryImpl = ctx.getBean(PersonSerfice.class);
          
          Person person = ctx.getBean(Person.class);
          
//            person.setId(Long.parseLong("2"));
//            person.setSurName(surName);
//            person.setName(name);
//            personRepositoryImpl.add(person);
//            
        Person p=    personRepositoryImpl.get(Long.parseLong("2"));
//         
        System.out.println("p: " +p.getName() +"_"+p.getSurName()+"_"+p.getId());
//            System.out.println("Person Added Successfully with id="+person.getId());
//            request.setAttribute("success", "Person Added Successfully");
            
//            List<Person> persons = personRepositoryImpl.findAll();
//          List<Person> data = new ArrayList<Person>();
            
           
           for (Person personList : personRepositoryImpl.getAll()) {
        	   System.out.println("kayýt: " + personList.getName()+ " "+personList.getSurName() +" "+personList.getId());
		    }
            
            request.setAttribute("persons", p);
 
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/persons.jsp");
            rd.forward(request, response);
        }

    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doPost(request, response);
    }
    
    
    
    
    
    }
 
