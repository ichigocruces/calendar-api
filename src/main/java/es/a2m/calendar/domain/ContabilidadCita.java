package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;


/**
 * The persistent class for the CONTABILIDAD_CITAS database table.
 * 
 */
@Data
@NoArgsConstructor
@Embeddable
@Table(name="CONTABILIDAD_CITAS")
@NamedQuery(name="ContabilidadCita.findAll", query="SELECT c FROM ContabilidadCita c")
public class ContabilidadCita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ANIO")
	private int anio;

	@Column(name="COD_TRATAMIENTO")
	private byte codTratamiento;

	@Column(name="DIA")
	private int dia;

	@Column(name="MES")
	private int mes;

	@Column(name="NUM_CITAS", nullable=false)
	private BigInteger numCitas;

}