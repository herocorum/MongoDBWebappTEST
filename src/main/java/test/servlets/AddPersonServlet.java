//package test.servlets;
// 
//import java.io.IOException;
//import java.io.Serializable;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import test.AppConfig;
//import test.model.Person;
//import test.service.PersonServiceImpl;
// 
//@WebServlet("/addPerson")
//public class AddPersonServlet extends HttpServlet implements Serializable{
//	private static final long serialVersionUID = 60948240650978848L;
//	
//    private static String INSERT_OR_EDIT = "/user.jsp";
//    private static String LIST_USER = "/listUser.jsp";
//    
//    
//    private static final Logger LOGGER = LoggerFactory.getLogger(AddPersonServlet.class);
//    
//    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String surName = request.getParameter("surName");
//        String action = request.getParameter("action");
//        String gsmNo = request.getParameter("gsmNo");
//        
//        
//        
////        if ((name == null || name.equals("")) || (surName == null || surName.equals(""))) {
////            request.setAttribute("error", "Mandatory Parameters Missing");
////            RequestDispatcher rd = getServletContext().getRequestDispatcher("/persons.jsp");
////            rd.forward(request, response);
////        } else {
//
//        	
//        	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//            
//            PersonServiceImpl personRepositoryImpl = ctx.getBean(PersonServiceImpl.class);
//            
//            Person person = ctx.getBean(Person.class);
//            
//            
//        	
//        	String forward="";
//            
//
//            if (action.equalsIgnoreCase("delete")){
//                int userId = Integer.parseInt(request.getParameter("userId"));
//                personRepositoryImpl.remove(Long.parseLong (String.valueOf(userId)) );
//                
//                forward = LIST_USER;
//                response.getWriter().print("Successfull");
//                
//                LOGGER.debug("successfully deleted ");
////                request.setAttribute("users", personRepositoryImpl.getAll());    
//            
//            }else if (action.equalsIgnoreCase("create")){
//            	
//            	String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
//                
//                System.out.println(gRecaptchaResponse);
//                boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
//            	
//                String fname = request.getParameter("name");
//                String lname =request.getParameter("surName");
//                String cellPhone = request.getParameter("gsmNo");
//                
//                if(verify){
//                	 person.setName(fname);
//                     person.setSurName(lname);
//                     person.setGsmNO(cellPhone);
//                     
//                     personRepositoryImpl.add(person);
//                     personRepositoryImpl.get(person.getId());
//                     
//                     response.getWriter().print("Successfull"); 
//                     LOGGER.debug("successfully created ");
//
//                }else{
//                	response.getWriter().print("failed"); 
//                    LOGGER.debug("creation failed ");
//
//                }
//                
//            }else if (action.equalsIgnoreCase("edit")){
//            	
//                forward = INSERT_OR_EDIT;
//                String editUserId = request.getParameter("userId");
//                String fname = request.getParameter("name");
//                String lname =request.getParameter("surName");
//                String cellPhone = request.getParameter("gsmNo");
//                
//                person =   personRepositoryImpl.get(Long.parseLong(String.valueOf(editUserId)));
//                
//                person.setName(fname);
//                person.setSurName(lname);
//                person.setGsmNO(cellPhone);
//                
//                personRepositoryImpl.update(person);
//                
//               Person newPerson = new Person(); 
//               newPerson= personRepositoryImpl.get(Long.parseLong (String.valueOf(editUserId)) );
//                
//                if(newPerson.equals(person)){
//                  response.getWriter().print("Successfull");
//                  LOGGER.debug("successfully updated ");
//                }else{
//                  response.getWriter().print("failed");
//                  LOGGER.debug("updating failed ");;
//                }
//                
////                PrintWriter out = response.getWriter();
////                out.append("Your string goes here");
////                out.close();
//            }else if (action.equalsIgnoreCase("listUser")){
//            	
//                forward = LIST_USER;
//                request.setAttribute("users", personRepositoryImpl.getAll());
//                RequestDispatcher rd = getServletContext().getRequestDispatcher(forward);
//              rd.forward(request, response);
//              LOGGER.debug("listing ");
//            } else {
//                forward = INSERT_OR_EDIT;
//            } 	
//        	
////            RequestDispatcher rd = getServletContext().getRequestDispatcher(forward);
////            rd.forward(request, response);
//
//    }
//
//    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    	doPost(request, response);
//    }
// }
// 
