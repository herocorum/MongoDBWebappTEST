<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>AJAX Test</title>
<script type="text/javascript" language="javascript" src="script/ajax.js"></script>
</head>
<body>
<form>
<div id="parentDiv">
	<div id="div_1">
		<table>
			<tr>
				<td><b>Name</b></td>
				<td><b>Trigram</b></td>
				<td><b>Company</b></td>
			</tr>
			<tr>
				<td><input type="text" id="name_1" value="name_1"></td>
				<td><input type="text" id="tri_1" value="tri_1"></td>
				<td><input type="text" id="cmp_1" value="cmp_1"></td>
			</tr>
		</table>
	</div>
</div>
<br>
<table>
	<tr>
		<td width="150"><a id ="addLink" style="display: block" href="javascript:addRowDiv()">Add Row</a></td>
		<td width="150"><a id="delLink" style="display: none" href="javascript:removeRowDiv()">Delete Above Row</a></td>
	</tr>
</table>
<br><input type="submit" value="Submit">
</form>
</body>
</html>