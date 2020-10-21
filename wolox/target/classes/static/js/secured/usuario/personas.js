
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
	}).done(function(listaUsuarios){
		
		listaUsuarios.forEach(function(user){
			var id =user.id;
			var valor= user.name + " - " +user.username ;
			modalWaitHide();
						
			$("#select_usuarios").append('<option value="'+id+'">'+ valor+'</option>');
		
			
		  
		});
		
			
	})
	.fail(function(data){
		modalError("La operación no pudo realizarse correctamente.", data)
	});


}

function verFotos(){

	$.ajax({
		    type: "GET", 
		    url: _path + "api/personas/fotos" ,
			beforeSend: function(xhr){
				xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );
				modalWaitShow();
			}
		}).done(function(listaFotos){
			
			listaFotos.forEach(function(photos){
				var id =photos.id;
				var valor= photos.title + " - " +photos.url ;
				modalWaitHide();
							
				$("#select_fotos").append('<option value="'+id+'">'+ valor+'</option>');
			
				
			  
			});
			
				
		})
		.fail(function(data){
			modalError("La operación no pudo realizarse correctamente.", data)
		});


	}