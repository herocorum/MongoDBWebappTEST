<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
	
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/blitzer/jquery-ui.css" type="text/css" />
		<link href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
		<script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.3.1/jquery.maskedinput.js"></script>
		
		  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
		
		
		<script>
			
			var stat="t";
		function makeCall(id,name,surName,statu,telno)
		{
			if (window.XMLHttpRequest){
				xRequest1 = new XMLHttpRequest();
			}else{
				xRequest1 = new ActiveXObject("Microsoft.XMLHTTP"); 
			}
			
				var newStatu="getAll";
				
				if(statu=="create")
					newStatu="create";
				else if(statu =="delete")
					newStatu="delete";
				else if(statu =="update")
					newStatu="update"
			
			
			var Form = document.getElementById('MyDialog');
	       	var append="action="+newStatu;
	       	
	        var count =0;
	       	var checkVar="";
	       	var myArr=[];
	        
	       	if(newStatu=="delete"){
	       		append =append+"&userId="+id;
	       	}else{
	       		for(I = 0; I < Form.length; I++) {
	                var Name = Form[I].getAttribute('name');
	                var value = Form[I].value;
	                append =append+"&"+Name+"="+value;
	                
	                
	                
	                if(Name =="name" &&value==""){
	                	checkVar =" "+checkVar +" firstname";
	                	myArr.push("showName");
	                	}
	                if(Name =="surName" &&value==""){
	                	checkVar =" "+checkVar +" lastname ";
	                	myArr.push("showSurName");
	                	}
	                if(Name =="g-recaptcha-response" &&value==""){
	                	checkVar =" "+checkVar +" captcha";
	                	myArr.push("showKapca");
	                	}
	                
	                if(Name !="gsmNo" && Name !="userId" && value !="" && value !=null)
	                	count++;
	                //I will take only firstname,lastname and catpcha it count 3 if all exist
	        	}
	       	}
	       	
	       	var inputt;
	       	
	       	var defArr =[];
	       	defArr.push("showKapca","showSurName","showName");
	       	
	       	if(newStatu=="create" && count !=3){
	       		
	       		for (var i = 0; i < defArr.length; i++) {
	       		document.getElementById(defArr[i]).style.display = "none";
	       		}
	       		
	       		for (var i = 0; i < myArr.length; i++) {
	       			document.getElementById(myArr[i]).style.display = "block";
	       		}
	       		
	       		$( "#yesno").dialog( "close" );
	       	}else{
			
	       	var	servletURL ="http://localhost:8080/MongoDBWebapp/mypath/getAll";
	       		
	       		if(newStatu =="create"){
	       			servletURL = "http://localhost:8080/MongoDBWebapp/mypath/create"; 
	       		}else if(newStatu=="update"){
	       			servletURL = "http://localhost:8080/MongoDBWebapp/mypath/update";
	       		}else if(newStatu=="delete"){
	       			servletURL = "http://localhost:8080/MongoDBWebapp/mypath/delete";
	       		}
	       		
	       		
	       		document.getElementById('loading').style.display = "block";
	        
	       	  
			 $.ajax({
			        type: "GET",
			        async:false,
			        url: servletURL, 
			        data: append , //"action="+newStatu +"&userId="+id+"&name="+name+"&surName="+surName,
			        success: function(response) {
			            if(response == "Successfull")
			            {
			            setTimeout(function(){document.getElementById('loading').style.display = "none"; 
			            alert("Your process is completed");
		            	$( "#yesno").dialog( "close" );
			            
			            }, 2000);
// 				       		document.getElementById('loading').style.display = "none";

			            	
			            }else{
			            	alert("process failed ...");
			            }
			        }
			    });
	       	}
		}
		
		
       	
		 
			
			function showFields(id,name,surName,cellPhone)
			{
				
			 
				var nameVal = document.getElementById("name"+name).value;
				var surNameVal = document.getElementById("surName"+surName).value;
				var IDval = document.getElementById("Id"+id).value;
				var gsmNOval = document.getElementById("gsmNO"+cellPhone).value;
				
			  
				var elemId = document.getElementById("userId");
				elemId.value = IDval;
				
				var elem = document.getElementById("userName");
				elem.value = nameVal;
				
				var elemSurname = document.getElementById("userSurName");
				elemSurname.value = surNameVal;
				
				var elemgsmNO = document.getElementById("maskon");
				elemgsmNO.value = gsmNOval;
				
				
			 
			    popupp(IDval,nameVal,surNameVal,"update",gsmNOval);
			 
			}
		
			
			function popupp(IDval,nameVal,surNameVal,action,telno){
				
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
							
							chooseDialog(IDval,nameVal,surNameVal,action,telno);
						
						},
						"Cancel": function() {
							$( this ).dialog( "close" );
							window.location = "http://localhost:8080/MongoDBWebapp/mypath/getAll";
						}
					},
					close: function() {
						$('#userId').val("");
						$('#userName').val("");
						$('#userSurName').val("");
						window.location = "http://localhost:8080/MongoDBWebapp/mypath/getAll";
					}
				});
				
				 if(IDval!=null && IDval !="" ){
					 var Form = document.getElementById('MyDialog');
				      
			       		for(I = 0; I < Form.length; I++) {
			                var Name = Form[I].getAttribute('name');
			                 if(Name =='g-recaptcha-response'){
//			                	 Form[I].setAttribute("hidden","hidden");
			                	 Form[I].setAttribute("style","display:none");
			                	 $('#kapca').hide();
			                 }
			        	}
			       		$( "#MyDialog" ).dialog( "open" );
				 
				 
				 }else{
					 
					 $( "#MyDialog" ).dialog( "open" );
				 }
				
			}
			
			function chooseDialog(IDval,nameVal,surNameVal,action,telno){
				
				 $( "#yesno" ).dialog({
				      resizable: false,
				      height:140,
				      modal: true,
				      buttons: {
				        "Yes": function() {
				        	
				        	if(action=="update"){
				        	    makeCall(IDval,nameVal,surNameVal,action,telno);
				        	}
				        	else if(action=="delete"){
				        		makeCall(IDval,name,surNameVal,action,telno);
				        		window.location = "http://localhost:8080/MongoDBWebapp/mypath/getAll";
				        	}
				        	else if(action=="create"){
				        		makeCall(IDval,name,surNameVal,action,telno);
				        	}
				        },
				        "NO": function() {
				        	$( this ).dialog( "close" );
				        	alert("your request canceled.!");
				        }
				      },
				 close: function( event ) {
					    if ( event.originalEvent ) {
					    	 window.location = "http://localhost:8080/MongoDBWebapp/mypath/getAll";
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
				    	alert("Delete ERROR");
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
			 
			 
			 
			 $(function() {
			 
			 
			 $("#maskon").keydown(function (e) {
					var key = e.charCode || e.keyCode || 0;
					$phone = $(this);

					// Auto-format- do not expose the mask as the user begins to type
					if (key !== 8 && key !== 9) {
						if ($phone.val().length === 4) {
							$phone.val($phone.val() + ')');
						}
						if ($phone.val().length === 5) {
							$phone.val($phone.val() + ' ');
						}			
						if ($phone.val().length === 9) {
							$phone.val($phone.val() + '-');
						}
					}

					// Allow numeric (and tab, backspace, delete) keys only
					return (key == 8 || 
							key == 9 ||
							key == 46 ||
							(key >= 48 && key <= 57) ||
							(key >= 96 && key <= 105));	
				})
				
				.bind('focus click', function () {
					$phone = $(this);
					
					if ($phone.val().length === 0) {
						$phone.val('(');
					}
					else {
						var val = $phone.val();
						$phone.val('').val(val); // Ensure cursor remains at the end
					}
				})
				
				.blur(function () {
					$phone = $(this);
					
					if ($phone.val() === '(') {
						$phone.val('');
					}
				});
			 
			 
			 
			 
			 
			});
			 
		</script>
			
	</head>
<body>
    <div id="users_table_container"> 
		<table id="users_table" class=" table table-hover table-bordered">
			<tr>
				<th>User Id</th>
				<th>First Name</th>
				<th>Last Name</th> 
				<th>GSM NO </th>
			</tr>
			
		    <c:forEach var="user" items="${users}">
               <tr>
                   <td><input type="text" value="${user.id}"      id="Id<c:out value="${user.id}"/>"    readonly="readonly"/></td>
                   <td><input type="text" value="${user.name}"    id="name<c:out value="${user.name}"/>"  readonly="readonly"/></td>
                   <td><input type="text" value="${user.surName}" id="surName<c:out value="${user.surName}"/>"  readonly="readonly"/></td>
				   <td><input type="text" value="${user.gsmNO}" id="gsmNO<c:out value="${user.gsmNO}"/>"  readonly="readonly"/></td>
    			   <td><input type="button" value="UPDATE"  onclick="showFields('${user.id}','${user.name}','${user.surName}','${user.gsmNO}')"></input></td>
                   <td><input type="button" value="DELETE"  onclick="deleteRow('${user.id}')"></input></td>
               </tr>
           </c:forEach>
		</table>
	</div>
	<p><input id="create-user" type="button" value="Add User" onclick="create()" ></input></p>
	             	
    	<form method="POST" action='/addPerson' name="frmAddUser" id="MyDialog" hidden="true">
    	    <input id="userId"    name="userId"        type="text"  hidden="true"   /> <br/>
    		<div id="showName"  style="display:none;color:#F80000 ;"  >*please enter</div>
      	    First Name : <input id="userName"    name="name"        type="text"     /> <br/> 
            <div id="showSurName"  style="display:none; color:#F80000 ;"  >*please enter</div>     
            Last Name : <input id="userSurName"  name="surName"       type="text"    /> <br/>  
            GSM: <input id="maskon" name="gsmNo" type="text" maxlength="14" placeholder="(XXX) XXX-XXXX" /><br /> 
          <div id="showKapca"  style="display:none; color:#F80000 ;"   >*please enter</div>   
          <div id="kapca" class="g-recaptcha" data-sitekey="6LfNDAgTAAAAAHNWpjniSdeenSgNW309s8BfFIRD"></div>
       </form>
  
  
  <a href="#" id="yesno"  hidden="true">Are You SURE ??
   <img id="loading" style="display: none"  src="http://preloaders.net/preloaders/287/Filling%20broken%20ring.gif"  />
  </a>
  
  <script src='https://www.google.com/recaptcha/api.js'></script>
     
     
</body>
</html>