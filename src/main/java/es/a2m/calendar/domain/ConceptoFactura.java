package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * The persistent class for the CONCEPTO_FACTURA database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="CONCEPTO_FACTURA")
@NamedQuery(name="ConceptoFactura.findAll", query="SELECT c FROM ConceptoFactura c")
public class ConceptoFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CANTIDAD")
	private int cantidad;

	@Column(name="COD_CONCEPTO", nullable=false)
	private int codConcepto;

	@Column(name="IMPORTE_UNI", precision=10, scale=2)
	private BigDecimal importeUni;

	@Column(name="NOMBRE", length=200)
	private String nombre;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="COD_FACTURA", referencedColumnName="COD_FACTURA", nullable=false)
	private Factura factura;

}