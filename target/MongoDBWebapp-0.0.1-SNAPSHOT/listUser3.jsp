<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Users</title>
 <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.3.2.min.js"></script>

 <script type="text/javascript">
		 
		 function doAjaxPost(){
			 $.ajax({
				 type: "POST",
				 url: "/MongoDBWebapp/addPerson",
				 data: "name=" + name + "&surName=" + surName,
			   
			    success: function(response){
			   $('#result').html("");
			   },
			  error: function(){      
			   alert('Error while request..');
			  }
			 });
			}
		  
        </script>

</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th> 
                <th>Email</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
       <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.surName}" /></td>
                     <td><input id="test" type="button" value="Add Users" onclick="doAjaxPost()"><br/></td> 
                   
                    <td><a href="/addPerson?action=edit&userId=<c:out value="${user.id}"/>">Update</a></td>
                </tr>
            </c:forEach>
        
            
        </tbody>
    </table>
    <h1>Spring Framework Jquery Ajax Demo</h1>
     <div id="result"></div>
    <p><a href="/addPerson?action=insert">Add User</a></p>
</body>
</html>