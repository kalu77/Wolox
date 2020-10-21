package ar.com.genomasoft.fenix.rest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.codehaus.jettison.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ar.com.genomasoft.fenix.model.Persona;
import ar.com.genomasoft.fenix.model.foto;
import ar.com.genomasoft.fenix.model.user;
import ar.com.genomasoft.fenix.reports.PdfGeneratorUtil;
import ar.com.genomasoft.fenix.service.PersonaService;
import ar.com.genomasoft.jproject.core.daos.ConditionEntry;
import ar.com.genomasoft.jproject.core.daos.ConditionSimple;
import ar.com.genomasoft.jproject.core.daos.SearchOption;
import ar.com.genomasoft.jproject.core.exception.BaseException;
import ar.com.genomasoft.jproject.webutils.webservices.BaseClientAuditedEntityWebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController

@Api("Personas - Servicio web REST")
@RequestMapping(path = "/api/personas")
public class PersonaRest extends BaseClientAuditedEntityWebService<Persona, PersonaService> {

	@GetMapping(path = "/usuarios")
	public @ResponseBody user[] usuarios() throws Exception {

		user[] userArray;

		// usamos esta url para los usuarios
		URL url = new URL("https://jsonplaceholder.typicode.com/users");

		// abrimos la conexion
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		// Getting the response code, nos asuguramos que nos devuelva 200 (OK)
		int responsecode = conn.getResponseCode();

		if (responsecode != 200) {
			throw new RuntimeException("HttpResponseCode: " + responsecode);
		} else {

			String json = "";// aca va a estar el Gson
			Scanner scanner = new Scanner(url.openStream());

			// Write all the JSON data into a string using a scanner
			while (scanner.hasNext()) {
				json += scanner.nextLine();
			}

			// Close the scanner
			scanner.close();

			Gson gson = new Gson();
			// convierte el Gson, en array de user. user es un clase.
			userArray = gson.fromJson(json, user[].class);

		}

		return userArray;
	}

	@GetMapping(path = "/fotos")
	public @ResponseBody foto[] fotos() throws Exception {

		foto[] fotosArray;

		// usamos esta url para las fotos
		URL url = new URL("https://jsonplaceholder.typicode.com/photos");

		// abrimos la conexion
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		// Getting the response code, nos asuguramos que nos devuelva 200 (OK)
		int responsecode = conn.getResponseCode();

		if (responsecode != 200) {
			throw new RuntimeException("HttpResponseCode: " + responsecode);
		} else {

			String json = "";// aca va a estar el Gson
			Scanner scanner = new Scanner(url.openStream());

			// Write all the JSON data into a string using a scanner
			while (scanner.hasNext()) {
				json += scanner.nextLine();
			}

			// Close the scanner
			scanner.close();

			Gson gson = new Gson();
			// convierte el Gson, en array de fotos. fotos es un clase.
			fotosArray = gson.fromJson(json, foto[].class);

		}

		return fotosArray;
	}
	
}
