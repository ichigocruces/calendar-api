package es.a2m.calendar.service;

import java.util.List;

import es.a2m.calendar.domain.Cliente;

public interface ClienteService {
	
	
	List<Cliente> findAllActiveClients();

}
