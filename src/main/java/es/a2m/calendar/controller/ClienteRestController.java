package es.a2m.calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.a2m.calendar.domain.Cliente;
import es.a2m.calendar.service.ClienteService;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteRestController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("")
	public @ResponseBody List<Cliente> getActiveClients() {
		return this.clienteService.findAllActiveClients();
		
	}
	
}
