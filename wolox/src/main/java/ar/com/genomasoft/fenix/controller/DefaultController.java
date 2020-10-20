package ar.com.genomasoft.fenix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import ar.com.genomasoft.jproject.core.daos.ManagerFetchs;
import ar.com.genomasoft.jproject.core.exception.InternalErrorException;

@Controller
public class DefaultController {
	
	/* ***** PAGINAS AUTENTICADAS (Para todos los PERFILES) ***** */
	@GetMapping(value={"/", "/home", "/index", "/usuario"})
	public String getDefaultPage() {
		return "/secured/index";
	}

	/* ***** PAGINAS PUBLICAS ***** */
	@GetMapping("/info")
	public String getInfoPage() {
		return "/info";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping(value="/demo")
	public String registration(){
		return "/demo";
	}
	
	@GetMapping(value="/registro")
	public String registroCliente(){
		// TODO el form de registro debe tener un captcha
		return "/registro";
	}

	
	/* ***** PAGINAS AUTENTICADAS PARA PERFIL USUARIO ***** */
	@GetMapping("/genoma/personas")
	public String usuarioPersonas() {
		return "/secured/genoma/personas";
	}
	

	
	/* ***** ERRORES ***** */
	
	@GetMapping("/403")
	public String error403() {
    	return "/error/403";
	}

	@GetMapping("/404")
	public String error404() {
	    return "/error/404";
	}

	@GetMapping("/500")
	public String error500() {
	    return "/error/500";
	}
}
