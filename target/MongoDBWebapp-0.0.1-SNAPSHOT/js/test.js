function doAjaxPost() {
	// get the form values
	var name = $('#name').val();
	var education = $('#surName').val();

	$.ajax({
		type : "POST",
		url : "/MongoDBWebapp/addPerson",
		data : "name=" + name + "&surName=" + surName,
		success : function(response) {
			// we have the response
			$('#info').html(response);
			$('#name').val('');
			$('#surName').val('');
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}
