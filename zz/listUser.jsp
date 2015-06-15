<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
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
        
		        <c:forEach items="${users}" var="user" varStatus="i" begin="0" >
		              <tr class="person">    
		                  <td><form:input  path="users[${user.id}].id" id="id${i.index}" /></td>
		                  <td><form:input path="users[${user.name}].name" id="name${i.index}" /></td>
		                  <td><form:input path="users[${user.surName}].surName" id="surName${i.index}" /></td>
		                  <td><a href="#" class="removePerson">Remove Person</a></td>
		              </tr>
		          </c:forEach>
        
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.surName}" /></td>
                    
                    <input  type="button" value="Add Users" onclick="doAjaxPost()"><br/></td></tr>
                  
                   <input type="button" value="Remove Element" onClick="doAjaxPost('name');">
                   
                    <td><a href="/addPerson?action=edit&userId=<c:out value="${user.id}"/>">Update</a></td>
                    <td><a href="/addPerson?action=delete&userId=<c:out value="${user.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="/addPerson?action=insert">Add User</a></p>
</body>
</html>