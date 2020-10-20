package ar.com.genomasoft.fenix;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ar.com.genomasoft.fenix.config.Application;
import ar.com.genomasoft.fenix.model.Persona;
import ar.com.genomasoft.fenix.service.PersonaService;
import ar.com.genomasoft.jproject.core.exception.BaseException;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(classes = {Application.class})
public class ApplicationTests {

	@Autowired
	PersonaService pservice;

	ArrayList<Persona> ListaPersona = new ArrayList<Persona>();
	
	@Test	 
	public void contextLoads() throws BaseException {
		
		Persona pe= new Persona();
		
		pe.setNombre("Luca");
		pe.setApellido("Gomez");
		pe.setEdad(28);

		
		
		ListaPersona.add(pe);
		
Persona pe1= new Persona();
		
		pe1.setNombre("Lucia");
		pe1.setApellido("Gonzalez");
		pe1.setEdad(29);

		
		
		ListaPersona.add(pe1);
		
Persona pe2= new Persona();
		
		pe2.setNombre("Marcos");
		pe2.setApellido("Peña");
		pe2.setEdad(3255);

		
		
		ListaPersona.add(pe2);
		
Persona pe3= new Persona();
		
		pe3.setNombre("Emanuel");
		pe3.setApellido("king");
		pe3.setEdad(30);

		
		
		ListaPersona.add(pe3);
		
Persona pe4= new Persona();
		
		pe4.setNombre("Pacha");
		pe4.setApellido("Mama");
		pe4.setEdad(68);

				
		ListaPersona.add(pe4);		
		
		
		
	}
	

	@Test	 
	public void Recorrer() {
		for (Persona persona : ListaPersona) {
			
		}
	}

}
