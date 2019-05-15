package es.a2m.calendar.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import es.a2m.calendar.domain.Cita;
import es.a2m.calendar.domain.Cliente;

@CrossOrigin(origins = "http://localhost:4200")
public interface CitaRepository extends CrudRepository<Cliente, Integer> {
	
//	@Query(value="select COD_CITA, FECHA_INI, FECHA_FIN, MOTIVO, PERSONAL, COD_CONCEPTO, COD_FACTURA, COD_AUSENCIA, CLIENTE.*, TRATAMIENTO.*, ESTADO.*, EMPLEADO.* \n" + 
//			"from CITA\n" + 
//			"	join CLIENTE on CLIENTE.COD_CLIENTE = CITA.COD_EMPLEADO\n" + 
//			"    join TRATAMIENTO on CITA.COD_TRATAMIENTO = TRATAMIENTO.COD_TRATAMIENTO\n" + 
//			"    join ESTADO on CITA.COD_ESTADO= ESTADO.COD_ESTADO\n" + 
//			"    join EMPLEADO on CITA.COD_EMPLEADO= EMPLEADO.COD_EMPLEADO\n" + 
//			"\n" + 
//			"where CITA.COD_ESTADO >= :codEstadoConfirmado\n" + 
//			"and CITA.FECHA_INI >= :fhIni and CITA.FECHA_FIN < :fhFin\n" + 
//			"and CITA.COD_EMPLEADO = :codEmpleado\n" + 
//			"order by CITA.COD_EMPLEADO;", nativeQuery=true)
	//@Query(value=" SELECT c FROM Cita c WHERE c.empleado.codEmpleado =:codEmpleado order by c.fechaIni ")
	@Query(name="fncCargarCitas",
			value="from Cita cita\n" + 
					"            join fetch cita.cliente\n" + 
					"            join fetch cita.tratamiento\n" + 
					"            join fetch cita.estado\n" + 
					"            join fetch cita.empleado\n" + 
					"      where cita.estado.codEstado >= :codEstadoConfirmado\n" + 
					"      and cita.fhIni >= :fhIni and cita.fhFin < :fhFin\n" + 
					"      and cita.empleado.codEmpleado = :codEmpleado\n" + 
					"      order by cita.fhIni")
	List<Cita> getAppointments(
			  @Param("codEstadoConfirmado") Integer codEstadoConfirmado, 
			  @Param("fhIni") Date fhIni,
			  @Param("fhFin") Date fhFin,
			  @Param("codEmpleado") int codEmpleado);

}
