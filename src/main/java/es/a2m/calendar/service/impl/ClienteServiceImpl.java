package es.a2m.calendar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.a2m.calendar.domain.Cliente;
import es.a2m.calendar.repository.ClienteRepository;
import es.a2m.calendar.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> findAllActiveClients(){
		return this.clienteRepository.findAllActiveClients();
	}

}
