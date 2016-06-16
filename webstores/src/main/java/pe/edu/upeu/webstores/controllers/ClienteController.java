package pe.edu.upeu.webstores.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@RequestMapping
	public String getAllClientes(Model model) {
		
		return "clientes/list";
	}

	@RequestMapping("/nuevo")
	public String getFormNuevoCliente(Model model) {
		return "clientes/form";
	}

}
