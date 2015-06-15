<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Setup and Load Data to jTable using Servlets and JSP</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //initialize jTable
        $('#PersonTableContainer').jtable({
            title: 'Table of people',
            actions: {
                listAction: 'CRUDController?action=list',
                createAction:'CRUDController?action=create',
                updateAction: 'CRUDController?action=update',
                deleteAction: 'CRUDController?action=delete'
            },
            fields: {
                customerid: {
                    key: true,
                    list: false
                },
                customername: {
                    title: 'Customer Name',
                    width: '30%'
                },
                email: {
                    title: 'Email',
                    width: '30%'
                },
                phone: {
                    title: 'Phone',
                    width: '20%',
                    create: false,
                    edit: false
                },
                city: {
                    title: 'City',
                    width: '20%',
                    
                }
                
            }
        });        
    });
</script>
</head>
<body>
<div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
<h1>Setup and Load Data in jTable using Servlet and JSP</h1>
<h4>Demo by Priya Darshini, Tutorial at www.programming-free.com</h4>
<div id="PersonTableContainer"></div>
</div>
</body>
</html>