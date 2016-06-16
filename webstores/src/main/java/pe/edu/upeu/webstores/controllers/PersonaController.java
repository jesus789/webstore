package pe.edu.upeu.webstores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upeu.webstores.domain.Persona;
import pe.edu.upeu.webstores.service.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@RequestMapping
	public String listar() {
		Persona p = new Persona();
		p.setNombre("Jesus Alberto");
		p.setApePaterno("Yucra");
		p.setApeMaterno(" Arce");

		personaService.guardar(p);
		return "personas/list";
	}

}
