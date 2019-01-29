package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * The persistent class for the EMPLEADO database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="EMPLEADO")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="APELLIDO1", nullable=false, length=50)
	private String apellido1;

	@Column(name="APELLIDO2", nullable=false, length=50)
	private String apellido2;

	@Column(name="COD_EMPLEADO", nullable=false)
	private int codEmpleado;

	@Column(name="DIRECCION", length=200)
	private String direccion;

	@Column(name="DNI", length=10)
	private String dni;

	@Temporal(TemporalType.DATE)
	@Column(name="FH_BAJA")
	private Date fhBaja;

	@Column(name="NOMBRE", nullable=false, length=20)
	private String nombre;

	@Column(name="PASSWORD", nullable=false, length=75)
	private String password;

	@Column(name="TELEFONO1", nullable=false)
	private int telefono1;

	@Column(name="TELEFONO2")
	private int telefono2;

	@Column(name="USUARIO", nullable=false, length=25)
	private String usuario;

	//uni-directional one-to-one association to Color
	@OneToOne
	@JoinColumn(name="COD_COLOR", referencedColumnName="COD_COLOR", nullable=false)
	private Color color;

	//uni-directional many-to-one association to Clinica
	@ManyToOne
	@JoinColumn(name="COD_CLINICA", referencedColumnName="COD_CLINICA", nullable=false)
	private Clinica clinica;

}