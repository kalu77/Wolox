$(document).ready(function() {

});

function verUsuarios() {

	$.ajax({
		type : "GET",
		url : _path + "api/personas/usuarios",
		beforeSend : function(xhr) {
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf);
			modalWaitShow();
		}
	}).done(
			function(listaUsuarios) {

				listaUsuarios.forEach(function(user) {
					var id = user.id;
					var valor = user.name + " - " + user.username + "-" + id;
					modalWaitHide();

					$("#select_usuarios").append('<option value="' + id + '">' + valor + '</option>');

				});

			}).fail(function(data) {
		modalError("La operación no pudo realizarse correctamente.", data)
	});

}

function verFotos() {

	$.ajax({
		type : "GET",
		url : _path + "api/personas/fotos",
		beforeSend : function(xhr) {
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf);
			modalWaitShow();
		}
	}).done(
			function(listaFotos) {

				listaFotos.forEach(function(photos) {
					var id = photos.id;
					var valor = photos.title + " - " + photos.url;
					modalWaitHide();

					$("#select_fotos").append('<option value="' + id + '">' + valor + '</option>');

				});

			}).fail(function(data) {
		modalError("La operación no pudo realizarse correctamente.", data)
	});

}

function verAlbum() {

	$.ajax({
		type : "GET",
		url : _path + "api/personas/album/",
		beforeSend : function(xhr) {
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf);
			modalWaitShow();
		}
	}).done(
			function(listaAlbumes) {

				listaAlbumes.forEach(function(album) {
					var id = album.id;
					var valor = album.title + " - " + album.userId;
					modalWaitHide();

					$("#select_album").append('<option value="' + id + '">' + valor + '</option>');

				});

			}).fail(function(data) {
		modalError("La operación no pudo realizarse correctamente.", data)
	});

}

function verAlbumporUsuario() {

	$("#select_Albumes_usuarios").empty();
	$('#select_Albumes_usuarios option').remove();

	$("#select_fotos_usuarios").empty();
	$('#select_fotos_usuarios option').remove();

	var idUsuario = $('#select_usuarios option:selected').attr('value');

	$.ajax({
		type : "GET",
		url : _path + "api/personas/albumUsuario/" + idUsuario,
		beforeSend : function(xhr) {
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf);
			modalWaitShow();
		}
	}).done(
			function(listaAlbumes) {

				listaAlbumes.forEach(function(album) {
					var id = album.id;
					var valor = album.title + " - " + album.userId;
					modalWaitHide();

					$("#select_Albumes_usuarios").append('<option value="' + id + '">' + valor + '</option>');

				});

			}).fail(function(data) {
		modalError("La operación no pudo realizarse correctamente.", data)
	});

}

function verFotosporUsuario() {

	$("#select_fotos_usuarios").empty();
	$('#select_fotos_usuarios option').remove();

	var idUsuario = $('#select_usuarios option:selected').attr('value');

	$.ajax({
		type : "GET",
		url : _path + "api/personas/photoForUsers/" + idUsuario,
		beforeSend : function(xhr) {
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf);
			modalWaitShow();
		}
	}).done(
			function(listaFotos) {

				listaFotos.forEach(function(fotos) {
					var id = fotos.id;
					var valor = fotos.url + " - " + fotos.albumId;
					modalWaitHide();

					$("#select_fotos_usuarios").append('<option value="' + id + '">' + valor+ '</option>');

				});

			}).fail(function(data) {
		modalError("La operación no pudo realizarse correctamente.", data)
	});

}

function commentsforUsers() {

	$("#select_comments").empty();
	$('#select_comments option').remove();

	var idUsuario = $('#select_usuarios option:selected').attr('value');

	$.ajax({
		type : "GET",
		url : _path + "api/personas/commentsForUsers/" + idUsuario,
		beforeSend : function(xhr) {
			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf);
			modalWaitShow();
		}
	}).done(
			function(listaComentarios) {

				listaComentarios.forEach(function(comments) {
					var id = comments.id;
					var valor = comments.body + " - " + comments.postId;
					modalWaitHide();

					$("#select_comments").append('<option value="' + id + '">' + valor + '</option>');

				});

			}).fail(function(data) {
		modalError("La operación no pudo realizarse correctamente.", data)
	});

}
