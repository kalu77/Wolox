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

	@Autowired
	PdfGeneratorUtil pdfGenaratorUtil;

	@Autowired
	PersonaService pservice;

	@GetMapping(path = "/usuarios")
	public @ResponseBody void usuarios() throws Exception {
		
		URL url = new URL("https://jsonplaceholder.typicode.com/users");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		//Getting the response code
		int responsecode = conn.getResponseCode();
		
				
				if (responsecode != 200) {
				    throw new RuntimeException("HttpResponseCode: " + responsecode);
				} else {
				  
				    String inline = "";
				    Scanner scanner = new Scanner(url.openStream());
				  
				   //Write all the JSON data into a string using a scanner
				    while (scanner.hasNext()) {
				       inline += scanner.nextLine();
				    }
				    
				    //Close the scanner
				    scanner.close();

				    //Using the JSON simple library parse the string into a json object
				    JSONParser parse = new JSONParser();
				    JSONObject data_obj = (JSONObject) parse.parse(inline);

				    //Get the required object from the above created object
				    JSONObject obj = (JSONObject) data_obj.get("Global");

				    //Get the required data using its key
				    System.out.println(obj.get("TotalRecovered"));
				}


	}

	@GetMapping(path = "/pdf", produces = { MediaType.APPLICATION_PDF_VALUE })
	@ApiOperation(value = "Listado de personas.")
	public @ResponseBody byte[] getPdf() throws Exception {
		Map<Object, Object> data = new HashMap<Object, Object>();
		data.put("titulo", "Personas");
		data.put("personas", service.findAll());
		byte[] reporte = pdfGenaratorUtil.createPdf("/pdf/personas", data);
		return reporte;
	}

	@GetMapping(path = "/validar/{persona}")
	public @ResponseBody Collection<Persona> validar(@PathVariable("persona") String persona) throws Exception {

		Persona P = new Gson().fromJson(persona, Persona.class);

		List<ConditionEntry> condiciones = new ArrayList<ConditionEntry>();

		condiciones.add(new ConditionSimple("documento", SearchOption.EQUAL, P.getDocumento()));
		condiciones.add(new ConditionSimple("nombre", SearchOption.EQUAL, P.getNombre()));
		condiciones.add(new ConditionSimple("nombre", SearchOption.EQUAL, P.getApellido()));

		Collection<Persona> personas = pservice.findByFilters(condiciones);

		if (personas.size() > 0) {
			System.out.println("usuario no disponible");

		} else {
			P.setDireccion("");
			P.setCreatedTime(new Date());
			P.setCreatedByUser(1);

			pservice.save(P);
			System.out.println("usuario creado correctamente");
		}
		return personas;

	}

	@GetMapping(path = "/guardarPersonalizado/{nombre}/{apellido}/{doc}")
	@Transactional
	public @ResponseBody void guardarPersonalizado(@PathVariable("nombre") String nom,
			@PathVariable("apellido") String ape, @PathVariable("doc") String doc) throws BaseException {

		Persona p = new Persona();
		p.setNombre(nom);
		p.setApellido(ape);
		p.setDocumento(doc);
		p.setCreatedByUser(1);

		pservice.save(p);

	}

	@GetMapping(path = "/FiltrarA")
	public @ResponseBody Collection<Persona> FiltrarA() throws Exception {

		// cree una lista de condicione, la cree, es decir que esta vacia
		List<ConditionEntry> condiciones = new ArrayList<ConditionEntry>();

		// creo mi objeto o mejor dicho mi condición.
		// esta condicion espera 3 argumentos
		// 1 . atributo del objeto a filtrar
		// 2. opcion de busqueda a cumplir
		// 3. el valor que va a cumplir esa opcion de busqueda

		ConditionSimple condicion1 = new ConditionSimple("nombre", SearchOption.BEGIN, "A");

		// agrego a la lista de condiciones
		condiciones.add(condicion1);
		

		List<Persona> personas = (List<Persona>) this.pservice.findByFilters(condiciones);

		return personas;

	}

}
