package es.a2m.calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.a2m.calendar.domain.Cliente;
import es.a2m.calendar.service.ClienteService;

@RestController
@RequestMapping("/clients")
public class ClienteRestController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/data")
	public @ResponseBody List<Cliente> getData() {
		return this.clienteService.findAllActiveClients();
		
	}
	
}
