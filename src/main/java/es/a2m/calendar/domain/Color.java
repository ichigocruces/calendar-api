package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * The persistent class for the COLOR database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="COLOR")
@NamedQuery(name="Color.findAll", query="SELECT c FROM Color c")
public class Color implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="COD_COLOR", nullable=false)
	private byte codColor;
	
	@Column(name="BODY", length=6)
	private String body;

	@Column(name="BORDER", length=6)
	private String border;

	@Column(name="COD_EMPLEADO")
	private int codEmpleado;

	@Column(name="DESCRIPCION", length=20)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="FH_BAJA")
	private Date fhBaja;

	@Column(name="HEADER", length=6)
	private String header;

	@Column(name="PRIMARY_C", length=6)
	private String primaryC;

	@Column(name="SECONDARY_C", length=6)
	private String secondaryC;

}