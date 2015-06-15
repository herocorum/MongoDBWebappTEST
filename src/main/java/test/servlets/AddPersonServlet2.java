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

 
@WebServlet("/addPerson2")
public class AddPersonServlet2 extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 60948240650978848L;
	
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        
//        if ((name == null || name.equals("")) || (surName == null || surName.equals(""))) {
//            request.setAttribute("error", "Mandatory Parameters Missing");
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/persons.jsp");
//            rd.forward(request, response);
//        } else {

        	
        	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
            
            PersonSerfice personRepositoryImpl = ctx.getBean(PersonSerfice.class);
            
            Person person = ctx.getBean(Person.class);
            
            
        	
        	String forward="";
            String action = request.getParameter("action");

            if (action.equalsIgnoreCase("delete")){
                int userId = Integer.parseInt(request.getParameter("userId"));
                personRepositoryImpl.remove(Long.parseLong (String.valueOf(userId)) );
                
                forward = LIST_USER;
                request.setAttribute("users", personRepositoryImpl.getAll());    
            } else if (action.equalsIgnoreCase("insert")){
            	//buraya bak
                forward = INSERT_OR_EDIT;
                int userId = Integer.parseInt(request.getParameter("userId"));
                person= personRepositoryImpl.get(Long.parseLong (String.valueOf(userId)) );
                request.setAttribute("user", person);
                
            }  else if (action.equalsIgnoreCase("edit")){
            	
                forward = INSERT_OR_EDIT;
                String editUserId = request.getParameter("userId");
                String fname = request.getParameter("name");
                String lname =request.getParameter("surName");
                
                person.setId(Long.parseLong(String.valueOf(editUserId)));
                person.setName(fname);
                person.setName(lname);
                
                personRepositoryImpl.update(person);
                
                
                person= personRepositoryImpl.get(Long.parseLong (String.valueOf(editUserId)) );
                request.setAttribute("user", person);
                
            } 
            
            
            else if (action.equalsIgnoreCase("listUser")){
            	
                forward = LIST_USER;
                request.setAttribute("users", personRepositoryImpl.getAll());
            } else {
                forward = INSERT_OR_EDIT;
            } 	
        	
            RequestDispatcher rd = getServletContext().getRequestDispatcher(forward);
            rd.forward(request, response);
//        }

    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doPost(request, response);
    }
    
    
    
    
    
    }
 
