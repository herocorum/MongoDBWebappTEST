<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration Form</title>
 
 <script language="javascript" type="text/javascript" src="js/jquery-1.11.3.js"></script>
<!-- <script type="text/javascript" src="/js/jquery-1.11.3.js"></script> -->
<%--  <script src="${resourceUrl}/js/jquery-1.11.3.js" type="text/javascript"> </script> --%>
          
<!--         <script type="text/javascript" src="resources/js/test.js"></script> -->
<!--         <script src="/js/jquery-1.8.3.min.js"  type="text/javascript" language="JavaScript"></script> -->
         
<%--          <link href="<c:url value="/resources/js/test.js" />" rel="stylesheet"> --%>
        
<%--         <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script> --%>
<%--                  <link href="<c:url value="/resources/js/test.js" />" rel="stylesheet"> --%>
        
<%--          <script type="text/javascript" src="<c:url value='/js/jquery-1.8.3.min.js' />"></script> --%>
         
        <script type="text/javascript">
        function doAjaxPost() {
        // get the form values
       
        var name = $('#name').val();
        var education = $('#surName').val();

        $.ajax({
        type: "POST",
        url: "/MongoDBWebapp/addPerson",
        data: "name=" + name + "&surName=" + surName,
        success: function(response){
        // we have the response
        $('#info').html(response);
        $('#name').val('');
        $('#surname').val('');
        },
        error: function(e){
        alert('Error: ' + e);
        }
        });
        }
        </script>
    </head>
    <body>
        <h1>Add Users using Ajax ........</h1>
        <table>
            <tr><td>Enter your name : </td><td> <input type="text" id="name"><br/></td></tr>
            <tr><td>LastName : </td><td> <input type="text" id="surName"><br/></td></tr>
            <tr><td colspan="2"><input type="button" value="Add Users" onclick="doAjaxPost()"><br/></td></tr>
            <tr><td colspan="2"><div id="info" style="color: green;"></div></td></tr>
        </table>
        <a href="/MongoDBWebapp/listUser.jsp">Show All Users</a>
    </body>
</html>