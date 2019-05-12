package es.a2m.calendar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import es.a2m.calendar.domain.Cliente;

@CrossOrigin(origins = "http://localhost:4200")
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	
	@Query("select c from Cliente c where c.fhBaja is null")
	List<Cliente> findAllActiveClients();

}
