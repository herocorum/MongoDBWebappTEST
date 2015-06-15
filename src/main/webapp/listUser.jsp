<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/blitzer/jquery-ui.css" type="text/css" />
		<link href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
		<script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
		<script>
			
// 		$(document).on('click', ".saveRow", function(){
// 	        var formId=$(this).closest("form").attr("id");
// 	        var form = $("#"+formId);
// 	        var htmlId=formId;
// 	        htmlId=getDivId(htmlId);
// 	        form.submit(function () {
// 	            $('.saveRow').html('Saving...').fadeIn();
// 	            var urlAction=form.attr('action');
// 	            var dataFields=form.serialize();
// 	            callActionUsingAjax(urlAction, dataFields, function (data) {
// 	                    var ajaxActionResult=ajaxResult(data);
// 	                    setHTMLContent(ajaxActionResult,htmlId);
// 	                    $('.popUpForm').dialog("close");
// 	            });
// 	         return false;
// 	        });
// 	    });
		
			var stat="t";
		function makeCall(id,name,surName,statu)
		{
			if (window.XMLHttpRequest){
				xRequest1 = new XMLHttpRequest();
			}else{
				xRequest1 = new ActiveXObject("Microsoft.XMLHTTP"); 
			}
			
				var newStatu="edit";
				
				if(statu=="create")
					newStatu="create";
				else if(statu =="delete")
					newStatu="delete";
			
			
			var Form = document.getElementById('MyDialog');
	       	var append="action="+newStatu;
	       	
	       	if(newStatu=="delete"){
	       		append =append+"&userId="+id;
	       	}else{
	       		for(I = 0; I < Form.length; I++) {
	                var Name = Form[I].getAttribute('name');
	                var value = Form[I].value;
	                append =append+"&"+Name+"="+value;
	        	}
	       	}
	       	
			
			 $.ajax({
			        type: "POST",
			        async:false,
			        url: "http://localhost:8080/MongoDBWebapp/addPerson", 
			        data: append , //"action="+newStatu +"&userId="+id+"&name="+name+"&surName="+surName,
			        success: function(response) {
			            if(response == "Successfull")
			            {
			            	alert("Your process is completed");
			            	$( "#yesno").dialog( "close" );
			            }else{
			            	alert("process failed ...");
			            }
			        }
			    });
		}
		
			
			function showFields(id,name,surName)
			{
				
			 
				var nameVal = document.getElementById("name"+name).value;
				var surNameVal = document.getElementById("surName"+surName).value;
				var IDval = document.getElementById("Id"+id).value;
			  
				var elemId = document.getElementById("userId");
				elemId.value = IDval;
				
				var elem = document.getElementById("userName");
				elem.value = nameVal;
				
				
				var elemSurname = document.getElementById("userSurName");
				elemSurname.value = surNameVal;
			 
			    popupp(IDval,nameVal,surNameVal,"edit");
			 
			}
		
			
			function popupp(IDval,nameVal,surNameVal,action){
				
				$( "#MyDialog" ).dialog({
					autoOpen: false,
					height: 300,
					width: 350,
					modal: true,
					buttons: {
						"Save": function() {
// 							$('#userId').val(IDval);
// 							$('#userName').val(nameVal);
// 							$('#userSurName').val(surNameVal);
							
							chooseDialog(IDval,nameVal,surNameVal,action);
						
						},
						"Cancel": function() {
							$( this ).dialog( "close" );
							window.location = "http://localhost:8080/MongoDBWebapp/addPerson?action=listUser";
						}
					},
					close: function() {
						$('#userId').val("");
						$('#userName').val("");
						$('#userSurName').val("");
						window.location = "http://localhost:8080/MongoDBWebapp/addPerson?action=listUser";
					}
				});
				
				 if(IDval!=null){
					 $( "#MyDialog" ).dialog( "open" );
				 }else{}
				
			}
			
			function chooseDialog(IDval,nameVal,surNameVal,action){
				 $( "#yesno" ).dialog({
				      resizable: false,
				      height:140,
				      modal: true,
				      buttons: {
				        "Yes": function() {
				        	
				        	if(action=="edit"){
				        	    makeCall(IDval,nameVal,surNameVal,action);
				        	}
				        	else if(action=="delete"){
				        		makeCall(IDval,name,surNameVal,action);
				        		window.location = "http://localhost:8080/MongoDBWebapp/addPerson?action=listUser";
				        	}
				        	else if(action=="create"){
				        		makeCall(IDval,name,surNameVal,action);
				        	}
				        },
				        "NO": function() {
				        	$( this ).dialog( "close" );
				        	alert("your request canceled.!");
				        }
				      },
				 close: function( event ) {
					    if ( event.originalEvent ) {
					    	 window.location = "http://localhost:8080/MongoDBWebapp/addPerson?action=listUser";
					    }
				 }
				 
				 });
			}
			
			 function deleteRow(userId){
				 if (window.XMLHttpRequest){
						xRequest1 = new XMLHttpRequest();
					}else{
						xRequest1 = new ActiveXObject("Microsoft.XMLHTTP");
					}
				 
				     var id = document.getElementById("Id"+userId).value;
					
				     if(userId!=null && userId!=""){
				    	 chooseDialog(id,'','',"delete");
				    }else{
				    	alert("fuckit");
				    }
			 } 
			 
			 
			 function create()
				{
					if (window.XMLHttpRequest){
						xRequest1 = new XMLHttpRequest();
					}else{
						xRequest1 = new ActiveXObject("Microsoft.XMLHTTP");
					}
					popupp('','','',"create");
// 					 chooseDialog('','','',"create");
				}
			
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
	<p><input id="create-user" type="button" value="Add User" onclick="create()" ></input></p>
	             	
    	<form method="POST" action='/addPerson' name="frmAddUser" id="MyDialog" hidden="true">
    	ID  : <input id="userId"    name="userId"        type="text"     /> <br/>
        First Name : <input id="userName"    name="name"        type="text"     /> <br/> 
        Last Name : <input id="userSurName"  name="surName"       type="text"    /> <br/>  
  </form>
  
  
  <a href="#" id="yesno"  hidden="true">Are You SURE ??</a>
  
</body>
</html>