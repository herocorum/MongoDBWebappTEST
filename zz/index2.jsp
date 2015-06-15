<!DOCTYPE>
<html>
<head>
<title>CRUD operations using jTable in J2EE</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#StudentTableContainer').jtable({
			title : 'users List',
			actions : {
				listAction : '/MongoDBWebapp/addPerson?action=listUser',
				createAction : 'addPerson?action=insert',
				updateAction : 'addPerson?action=edit',
				deleteAction : 'addPerson?action=delete'
			},
			fields : {
		  
				name : {
					title : 'userId',
					width : '30%',
					edit : true
				},
				department : {
					title : 'name',
					width : '30%',
					edit : true
				},
				emailId : {
					title : 'surName',
					width : '20%',
					edit : true
				}
			}
		});
		$('#StudentTableContainer').jtable('load');
	});
</script>

</head>
<body>
<div style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">

		<h4>AJAX based CRUD operations using jTable in J2ee</h4>
		<div id="StudentTableContainer"></div>
	</div>
</body>
</html>