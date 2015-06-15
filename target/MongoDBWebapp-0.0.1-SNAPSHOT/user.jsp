<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
 <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.3.2.min.js"></script>

<script type="text/javascript">
        $(document).ready(function() {
          
        	
//         	function getURLParameter(name) {
//         		  return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null
//         	}
//         	var id =	getURLParameter('id');	
//         	var name =	getURLParameter('name');
//         	var surName = getURLParameter('surName');
       	   
        });
     	function Get(){
     		 var xmlhttp;
    	        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
    	            xmlhttp = new XMLHttpRequest();
    	        } else {// code for IE6, IE5
    	            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    	        }
     		
     		var Form = document.getElementById('test');
	       	var append="action=edit";
	       	for(I = 0; I < Form.length; I++) {
	                var Name = Form[I].getAttribute('name');
	                var value = Form[I].value;
	                append =append+"&"+Name+"="+value;
	        }
	   	    xmlhttp.open("GET", "/MongoDBWebapp/addPerson?"+append, true);
	        xmlhttp.send();
     	}
     	
     	
     	function Create(){
     		var xmlhttp;
	        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
	            xmlhttp = new XMLHttpRequest();
	        } else {// code for IE6, IE5
	            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	        }
 		
	 		var Form = document.getElementById('test');
	       	var append="action=create&userId=";
	       	 
	     	for(I = 1; I < Form.length; I++) {
                var Name = Form[I].getAttribute('name');
                var value = Form[I].value;
                append =append+"&"+Name+"="+value;
        	}
	            xmlhttp.open("GET", "/MongoDBWebapp/addPerson?"+append, true);
	   	        xmlhttp.send();
	        }
	   	    
	        
        
	        
     	
     	
    </script>

<title>Add new user</title>
</head>
<% 
    String id =  request.getParameter("id");
    if(id ==null){
    	id ="";
    }

    String name =  request.getParameter("name");
    if(name ==null){
    	name ="";
    }
    	
    String surName =  request.getParameter("surName");
    if(surName ==null){
    	surName ="";
    }
   
    	
    	
// 	String name = request.getParameter("name");
// 	String surName = request.getParameter("surName");
%>

<body>
   	<form method="POST" action='/addPerson' name="frmAddUser" id="test">
   		<a style="visibility:<%if(id=="") out.print("hidden;");else out.print("visible;");%>;">
       	  User ID :	<input id="userId" name="userId" type="text" value="<%=id%>"     readonly="readonly"  /> <br /> 
        </a>
       First Name : <input id="userName"    name="name"        type="text" value="<%=name%>"     /> <br/> 
       Last Name : <input id="userSurName"  name="surName"       type="text" value="<%=surName %>"  /> <br/>  
   </form>
   <button> 
  	 <a href="/MongoDBWebapp/addPerson?action=listUser"/> Back</a>
   </button>
   
    <td><input type="button" value="<%if(id=="")out.print("CREATE");else out.print("UPDATE"); %>"
    onclick="<%if(id=="")out.print("Create()");else out.print("Get()"); %>"></input></td>
    
    
    
</body>
</html>