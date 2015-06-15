<%@page import="java.lang.reflect.Field"%>
<%@page import="com.mkyong.model.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Users</title>
<!--  <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.3.2.min.js"></script> -->
<%-- <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.2.js"></script> --%>
<%-- <script type="text/javascript" language="javascript"  src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.js"></script> --%>

 <script type="text/javascript">

// 		 window.location = "http://localhost:8080/MongoDBWebapp/user.jsp?name="+name + "&surName=" + surName +"&id="+id, "true";

 function showFields(id,name,surName) {
        var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        
           var name = document.getElementById("name"+name).value ;
           var surName = document.getElementById("surName"+surName).value;
   		   var id = document.getElementById("Id"+id).value;
          
   		   
   		 var Form = document.getElementById('Form');
   	     for(I = 0; I < Form.length; I++) {
   	    	var name = Form[I].getAttribute('name'+name);
   	        var nameValue = Form[I].value; 
   	        
   	        var surName = Form[I].getAttribute('surName'+surName);
	        var surNameValue = Form[I].value; 
	        
	        var Id = Form[I].getAttribute('Id'+Id);
   	        var IdValue = Form[I].value; 
   	        
   	        
//    	         var Name = Form[I].getAttribute('name');
//    	         var Value = Form[I].value;
//    	         alert(Name + ' : ' + Value);
   	     }
   		   
//    	  function showFields(id,name,surName) {
//  	        var xmlhttp;
//  	        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
//  	            xmlhttp = new XMLHttpRequest();
//  	        } else {// code for IE6, IE5
//  	            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
//  	        }
//  	        xmlhttp.onreadystatechange = function() {
//  	            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//  	                document.getElementById("userId"+id).innerHTML=xmlhttp.responseText;
//  	                document.getElementById("userName"+name).innerHTML=xmlhttp.responseText;
//  	                document.getElementById("userSurName"+surName).innerHTML=xmlhttp.responseText;
//  	            }
//  	        }
//  	        xmlhttp.open("GET", "/addPerson", true);
//  	        xmlhttp.send();
//  	    }
 	   
    
//   });
       
        xmlhttp.open("GET", "/MongoDBWebapp/addPerson?action=edit&name="+name + "&surName=" + surName +"&userId="+id, true);
        xmlhttp.send();
    }
 
 
 function refleshData(name){
// 	 var name = document.getElementById("name"+name) ;
 
	 document.getElementById("name"+name).innerText;
    document.getElementById("name"+name).TEXT_NODE;
    document.getElementById("name"+name).avalue;
 	document.getElementsByName(name);
 }
 
 
 
						// 	 data: "name=" + name + "&surName=" + surName,
        </script>
</head>

<% 

	String id =   request.getParameter("id");
	String name =   request.getParameter("name");
	String surName =   request.getParameter("surName");
%>

<body>
    <div id="users_table_container"> 
    o
		<table id="users_table" class=" table table-hover table-bordered">
			<tr>
				<th>User Id</th>
				<th>First Name</th>
				<th>Last Name</th> 
				<th>Email</th>
				<th>Update </th>
				<th>Delete</th>
			</tr>
			
		    <c:forEach var="user" items="${users}">
               <tr>
                
               
                   <td><input type="text" value="<%=request.getAttribute("users").getClass().getField("name") %>"      id="Id<c:out value="${user.id}"/>"    readonly="readonly"/></td>
                   <td><input type="text" value="${user.name}"    id="name<c:out value="${user.name}"/>"  readonly="readonly"/></td>
                   <td><input type="text" value="${user.surName}" id="surName<c:out value="${user.surName}"/>"  readonly="readonly"/></td>
                   
<!--                    <td><input id="test" type="button" value="Update" onclick="showFields()"><br/></td>  -->
                  <td><input type="button" value="Update"  onclick="showFields('${user.id}','${user.name}','${user.surName}')"></input></td>
               </tr>
           </c:forEach>
			
			 
		</table>
	</div>
</body>
</html>