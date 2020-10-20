
$(document).ready(function(){

	 

});



function verUsuarios(){

$.ajax({
	    type: "GET", 
	    url: _path + "api/personas/usuarios" ,
		beforeSend: function(xhr){
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );
			modalWaitShow();
		}
	}).done(function(usuarios){
		
	})
	.fail(function(data){
		modalError("La operación no pudo realizarse correctamente.", data)
	});


}