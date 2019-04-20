package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;


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
	private byte codClinica;

	@Column(name="DIRECCION", nullable=false, length=20)
	private String direccion;

	@Column(name="DIVISION", nullable=false)
	private byte division;

	@Column(name="DURACION", nullable=false)
	private byte duracion;

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

	//uni-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="COD_EMPLEADO", referencedColumnName="APELLIDO1", nullable=false)
	private Empleado empleado;

}