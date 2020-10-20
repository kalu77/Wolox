$(document).ready(function() {
	$("#alta_alumno").hide();
	$("#lista_alumno").hide();
	$("#edicion_alumno").hide();
});



function cargarFormEdicion(){
	
	$("#lista_alumno").hide();
	
	$("#edicion_alumno").show();
	
	
	var idAlumno= $('#select_alumnos option:selected').attr('value');
		
	$.ajax({
	    type: "GET", 
	    url: _path + "api/alumnos/"+ idAlumno  ,
		beforeSend: function(xhr){
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );
			modalWaitShow();
		}
	}).done(function(alumno){
		$("#txtNombre_e").val(alumno.nombre);
		$("#txtApellido_e").val(alumno.apellido);
		$("#txtEdad_e").val(alumno.edad);		
		modalWaitHide();
	})
	.fail(function(data){
		modalError("La operación no pudo realizarse correctamente.", data)
	});

}

function cargarFormEdicion_old(){
	
	$("#lista_alumno").hide();
	
	$("#edicion_alumno").show();
	
	
	var idAlumno= $('#select_alumnos option:selected').attr('value');
		
	$.ajax({
	    type: 'GET', 
	    url: _path + "api/alumnos/buscarAlumno/"+ idAlumno  ,
		beforeSend: function(xhr){
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );
			modalWaitShow();
		}
	}).done(function(alumno){
		$("#txtNombre_e").val(alumno.nombre);
		$("#txtApellido_e").val(alumno.apellido);
		$("#txtEdad_e").val(alumno.edad);		
		modalWaitHide();
	})
	.fail(function(data){
		modalError("La operación no pudo realizarse correctamente.", data)
	});

}


function guardarAlumno(){
	var nombre=$("#txtNombre").val();
	var apellido=$("#txtApellido").val();
	var edad=$("#txtEdad").val();


	var alumnoJSON={};
		
	alumnoJSON["nombre"] = nombre;
	alumnoJSON["apellido"] = apellido;	
	alumnoJSON["edad"] =edad;


var jeyson=JSON.stringify(alumnoJSON);

	$.ajax({
	    type: 'POST', 
	    url: _path + "api/alumnos/",
		data:jeyson ,
	    dataTYpe: 'json',
	    contentType: 'application/json',
		beforeSend: function(xhr){
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );
			modalWaitShow();
		}
	}).done(function(){
		modalSuccess("Operación realizada correctamente.");
		$("#alta_alumno").hide();
		$("#txtNombre").val("");
		$("#txtApellido").val("");
		$("#txtEdad").val("");
	})
	.fail(function(data){
		modalError("La operación no pudo realizarse correctamente.", data)
	});

}


function guardarAlumno_old(){
	var nombre=$("#txtNombre").val();
	var apellido=$("#txtApellido").val();
	var edad=$("#txtEdad").val();

	$.ajax({
	    type: 'GET', 
	    url: _path + "api/alumnos/guardar/"+ nombre + "/" +apellido+ "/" +edad  ,
		beforeSend: function(xhr){
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );
			modalWaitShow();
		}
	}).done(function(){
		modalSuccess("Operación realizada correctamente.");
		$("#alta_alumno").hide();
		$("#txtNombre").val("");
		$("#txtApellido").val("");
		$("#txtEdad").val("");
	})
	.fail(function(data){
		modalError("La operación no pudo realizarse correctamente.", data)
	});

}

function mostrarFormAltaAlumno(){
	$("#alta_alumno").show();
}

function mostrarFormListaAlumno(){
	$("#lista_alumno").show();
	cargarSelectorAlumnos();
}


function cargarSelectorAlumnos(){

$.ajax({
	    type: 'GET', 
	    url: _path + "api/alumnos/listar" ,
		beforeSend: function(xhr){
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );
			modalWaitShow();
		}
	}).done(function(listaAlumnos){
		
		listaAlumnos.forEach(function(alumno){
			var id =alumno.id;
			var valor= alumno.nombre + " - " +alumno.apellido ;
			var version= alumno.version;
			
			$("#select_alumnos").append('<option version="'+ version +' "value="'+id+'">'+ valor+'</option>');
			
		  
		});
		
		modalWaitHide();
		
	})
	.fail(function(data){
		modalError("La operación no pudo realizarse correctamente.", data)
	});

}

function guardarModificaciones(){
	
	var nom_modifi = $("#txtNombre_e").val();
	var ape_modifi = $("#txtApellido_e").val();
	var edad_modifi = $("#txtEdad_e").val();
	var idAlumno= $('#select_alumnos option:selected').attr('value');
	
		$.ajax({
	    type: 'GET', 
	    url: _path + "api/alumnos/actualizar/"+ nom_modifi + "/" +ape_modifi+ "/" +edad_modifi+ "/" +idAlumno  ,
		beforeSend: function(xhr){
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );
			modalWaitShow();
		}
	}).done(function(){
		modalSuccess("Operación realizada correctamente.");
		$("#edicion_alumno").hide();
		$("#txtNombre_e").val("");
		$("#txtApellido_e").val("");
		$("#txtEdad_e").val("");
	})
	.fail(function(data){
		modalError("La operación no pudo realizarse correctamente.", data)
	});
		



}


function eliminar(){
	
		var idAlumno= $('#select_alumnos option:selected').attr('value');
	
		$.ajax({
	    type: 'GET', 
	    url: _path + "api/alumnos/eliminar/"+ idAlumno  ,
		beforeSend: function(xhr){
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );
			modalWaitShow();
		}
	}).done(function(){
		modalSuccess("Operación realizada correctamente.");
		$("#edicion_alumno").hide();
		$("#txtNombre_e").val("");
		$("#txtApellido_e").val("");
		$("#txtEdad_e").val("");
	})
	.fail(function(data){
		modalError("La operación no pudo realizarse correctamente.", data)
	});


}