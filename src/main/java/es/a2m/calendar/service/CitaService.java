package es.a2m.calendar.service;

import java.util.Date;
import java.util.List;

import es.a2m.calendar.domain.Cita;

public interface CitaService {

	List<Cita> getAppointments(Date fhIni, Date fhFin, Integer codEmpleado);
	
	void delete(Integer codCita);

}
