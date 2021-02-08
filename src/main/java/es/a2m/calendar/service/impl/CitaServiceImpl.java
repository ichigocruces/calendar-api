package es.a2m.calendar.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.a2m.calendar.domain.Cita;
import es.a2m.calendar.repository.CitaRepository;
import es.a2m.calendar.service.CitaService;
import es.a2m.calendar.utils.Constants;

@Service
public class CitaServiceImpl implements CitaService {
	
	@Autowired
	private CitaRepository citaRepository;


	@Override
	public List<Cita> getAppointments(Date fhIni, Date fhFin, Integer codEmpleado) {
		return this.citaRepository.getAppointments(Constants.COD_ESTADO_CONFIRMADO, fhIni, fhFin, codEmpleado);
	}


	@Override
	public void delete(Integer codCita) {
		this.citaRepository.deleteById(codCita);
	}
	

}
