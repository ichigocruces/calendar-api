package es.a2m.calendar.domain;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the CLINICA database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="CLINICA")
@NamedQuery(name="Clinica.findAll", query="SELECT c FROM Clinica c")
public class Clinica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="COD_CLINICA", nullable=false)
	private int codClinica;

	@Column(name="DIRECCION", nullable=false, length=20)
	private String direccion;

	@Column(name="DIVISION", nullable=false)
	private int division;

	@Column(name="DURACION", nullable=false)
	private int duracion;

	@Column(name="EMAIL", length=200)
	private String email;

	@Column(name="HORA_FIN", nullable=false)
	private Time horaFin;

	@Column(name="HORA_INI", nullable=false)
	private Time horaIni;

	@Column(name="NOMBRE", nullable=false, length=50)
	private String nombre;

	@Column(name="TELF1", nullable=false)
	private int telf1;

	@Column(name="TELF2")
	private int telf2;

	@Column(name="COD_EMPLEADO", nullable=false)
	private int codEmpleado;

}