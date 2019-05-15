package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the FACTURA database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="FACTURA")
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="COD_FACTURA", nullable=false)
	private String codFactura;

	@Column(name="COD_CLIENTE", nullable=false)
	private int codCliente;

	@Temporal(TemporalType.DATE)
	@Column(name="FH_CREACION")
	private Date fhCreacion;

	@Column(name="IMPORTE_TOTAL", nullable=false, precision=10, scale=2)
	private BigDecimal importeTotal;

	//bi-directional many-to-one association to ConceptoFactura
	@OneToMany(mappedBy="id.codFactura")
	private List<ConceptoFactura> conceptoFacturas;

	public List<ConceptoFactura> getConceptoFacturas() {
		return this.conceptoFacturas;
	}

	public void setConceptoFacturas(List<ConceptoFactura> conceptoFacturas) {
		this.conceptoFacturas = conceptoFacturas;
	}

	public ConceptoFactura addConceptoFactura(ConceptoFactura conceptoFactura) {
		getConceptoFacturas().add(conceptoFactura);
		
		return conceptoFactura;
	}

	public ConceptoFactura removeConceptoFactura(ConceptoFactura conceptoFactura) {
		getConceptoFacturas().remove(conceptoFactura);

		return conceptoFactura;
	}

}