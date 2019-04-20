package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the AUSENCIA database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="AUSENCIA")
@NamedQuery(name="Ausencia.findAll", query="SELECT a FROM Ausencia a")
public class Ausencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="COD_AUSENCIA", nullable=false)
	private byte codAusencia;

	@Column(name="DESCRIPCION", nullable=false, length=50)
	private String descripcion;

	@Column(name="DIAS_COMPLETOS", nullable=false, length=1)
	private String diasCompletos;

}