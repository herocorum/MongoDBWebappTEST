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
<script language="javascript" type="text/javascript" src="js/jquery-1.11.3.js"></script>


 <script type="text/javascript">

 function showFields(id,name,surName)
	{
		if (window.XMLHttpRequest){
			xRequest1 = new XMLHttpRequest();
		}else{
			xRequest1 = new ActiveXObject("Microsoft.XMLHTTP");
		}
	 
		var name = document.getElementById("name"+name).value;
		var surName = document.getElementById("surName"+surName).value;
		var id = document.getElementById("Id"+id).value;
		
		
		 window.location = "http://localhost:8080/MongoDBWebapp/user.jsp?name="+name + "&surName=" + surName +"&id="+id, "true";

	}
 
	 function create()
		{
			if (window.XMLHttpRequest){
				xRequest1 = new XMLHttpRequest();
			}else{
				xRequest1 = new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			 window.location = "http://localhost:8080/MongoDBWebapp/addPerson?action=prepareAdd", "true";
	
		}
	 function deleteRow(userId){
		 if (window.XMLHttpRequest){
				xRequest1 = new XMLHttpRequest();
			}else{
				xRequest1 = new ActiveXObject("Microsoft.XMLHTTP");
			}
		 
		     var id = document.getElementById("Id"+userId).value;
			
		     if(userId!=null && userId!=""){
				 window.location = "http://localhost:8080/MongoDBWebapp/addPerson?action=delete&userId="+id, "true";
		    }else{
		    	alert("fuckit");
		    }
	 } 
 
	// 				 data: "name=" + name + "&surName=" + surName,
			   
		 
        </script>

</head>
<body>
    <div id="users_table_container"> 
		<table id="users_table" class=" table table-hover table-bordered">
			<tr>
				<th>User Id</th>
				<th>First Name</th>
				<th>Last Name</th> 
				<th>Edit </th>
				<th>Delete</th>
			</tr>
			
		    <c:forEach var="user" items="${users}">
               <tr>
                
               
                   <td><input type="text" value="${user.id}"      id="Id<c:out value="${user.id}"/>"    readonly="readonly"/></td>
                   <td><input type="text" value="${user.name}"    id="name<c:out value="${user.name}"/>"  readonly="readonly"/></td>
                   <td><input type="text" value="${user.surName}" id="surName<c:out value="${user.surName}"/>"  readonly="readonly"/></td>
                   
<!--                    <td><input id="test" type="button" value="Update" onclick="showFields()"><br/></td>  -->
     <td><input type="button" value="EDIT"  onclick="showFields('${user.id}','${user.name}','${user.surName}')"></input></td>
     <td><input type="button" value="DELETE"  onclick="deleteRow('${user.id}')"></input></td>
             
               </tr>
           </c:forEach>
			
			 
		</table>
	</div>
	<p><input type="button" value="Add User"  onclick="create()"></input></p>
              
</body>
</html>