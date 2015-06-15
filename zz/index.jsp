<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Persons Manage Page</title>
<style>
table,th,td {
    border: 1px solid black;
}
</style>
</head>
<body>
 
<%--     <c:url value="/addPerson" var="addURL"></c:url>  --%>

 <%-- Add Request --%>
         <form action='<c:out value="todos"></c:out>' method="get">
            Name:    <input type="text" name="name"><br> 
            Country: <input type="text" name="surName"><br> 
            <input type="submit" value="Add Person">
        </form>
     
 
 <%-- Persons List Logic --%>
        <table>
            <tbody>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Country</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${persons}" var="person">
                    <tr>
                        <td><c:out value="${person.id}"></c:out></td>
                        <td><c:out value="${person.name}"></c:out></td>
                        <td><c:out value="${person.surName}"></c:out></td>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>