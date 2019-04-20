package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the IMPORTE_TRATAMIENTO database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="IMPORTE_TRATAMIENTO")
@NamedQuery(name="ImporteTratamiento.findAll", query="SELECT i FROM ImporteTratamiento i")
public class ImporteTratamiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId ImporteTratamientoId id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FH_FIN")
	private Date fhFin;

	@Temporal(TemporalType.DATE)
	@Column(name="FH_INI")
	private Date fhIni;

	@Column(name="IMPORTE", precision=10, scale=2)
	private BigDecimal importe;

	
	@Data
	@NoArgsConstructor
	@Embeddable
	class ImporteTratamientoId implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		//bi-directional many-to-one association to Tratamiento
		@ManyToOne
		@JoinColumn(name="COD_TRATAMIENTO", referencedColumnName="COD_TRATAMIENTO", nullable=false)
		private Tratamiento tratamiento;
		
		@Column(name="CORRELATIVO", nullable=false)
		private int correlativo;
		
	}

}