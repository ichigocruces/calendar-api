package es.a2m.calendar.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.a2m.calendar.domain.Cita;
import es.a2m.calendar.domain.Cliente;
import es.a2m.calendar.service.CitaService;
import es.a2m.calendar.service.ClienteService;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaRestController {
	
	@Autowired
	private CitaService citaService;
	
	@GetMapping("")
	public @ResponseBody List<Cita> getAppointments(
			@RequestParam("starDate") Date fhIni, 
			@RequestParam("endDate") Date fhFin, 
			@RequestParam("employeeId") Integer codEmpleado) {
		return this.citaService.getAppointments(fhIni, fhFin, codEmpleado);
		
	}
	
}
