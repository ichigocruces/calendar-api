package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TRATAMIENTO database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="TRATAMIENTO")
@NamedQuery(name="Tratamiento.findAll", query="SELECT t FROM Tratamiento t")
public class Tratamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="COD_TRATAMIENTO", nullable=false)
	private int codTratamiento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FH_BAJA")
	private Date fhBaja;

	@Column(name="NOMBRE", length=50)
	private String nombre;

	//bi-directional many-to-one association to ImporteTratamiento
	@OneToMany(mappedBy="id.codTratamiento", fetch=FetchType.LAZY)
	private List<ImporteTratamiento> importeTratamientos;

}