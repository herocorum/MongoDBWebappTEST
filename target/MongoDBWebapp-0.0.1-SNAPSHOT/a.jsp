<html>

<head>

<title>Employee Detail</title>

<script>
	function showFields(string1)
	{
		var xRequest1;
		if (string1 == ""){
			document.getElementById("Show_update").innerHTML = "";
			return;
		}

		if (window.XMLHttpRequest){
			xRequest1 = new XMLHttpRequest();
		}else{
			xRequest1 = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xRequest1.onreadystatechange = function(){
			if ((xRequest1.readyState == 4) && (xRequest1.status == 200)){
				document.getElementById("Show_update").innerHTML
				= xRequest1.responseText;
			}
		}

		xRequest1.open("get", "empdetails.jsp?q=" + string1, "true");
		xRequest1.send();

	}
</script>

</head>

<body>
	<form>
		<select name="user_name" onchange="getempdetails(this.value)">
			<option value="">Employee Designations</option>
			<option value="Officer">Officer</option>
			<option value="Supervisor">Supervisor</option>
			<option value="Manager">Manager</option>
		</select>
	</form>
	<br />
	<div id="Show_update">To Update the designation...</div>
</body>
</html>