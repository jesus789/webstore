package pe.edu.upeu.webstores.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/saludo")
	public String saludar(Model model) {

		model.addAttribute("nombre", "Jesus");

		return "hola";
	}

}

