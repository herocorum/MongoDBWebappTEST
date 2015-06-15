<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String id =  request.getParameter("tempId");%>
<table>
		<tr>
			<td><input type="text" id="name_<%=id%>" value="name_<%=id%>"></td>
			<td><input type="text" id="tri_<%=id%>" value="tri_<%=id%>"></td>
			<td><input type="text" id="cmp_<%=id%>" value="cmp_<%=id%>"></td>
		</tr>
	</table>
</body>
</html>