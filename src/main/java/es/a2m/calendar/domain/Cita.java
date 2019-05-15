package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * The persistent class for the CITA database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="CITA")
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="COD_CITA", nullable=false)
	private int codCita;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_FIN")
	private Date fhFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_INI")
	private Date fhIni;

	@Column(name="MOTIVO", length=2000)
	private String motivo;

	@Column(name="PERSONAL", length=1)
	private String personal;

	//uni-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="COD_CLIENTE", referencedColumnName="COD_CLIENTE")
	private Cliente cliente;

	//uni-directional many-to-one association to Ausencia
	@ManyToOne
	@JoinColumn(name="COD_AUSENCIA", referencedColumnName="COD_AUSENCIA")
	private Ausencia ausencia;

	//uni-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="COD_EMPLEADO", referencedColumnName="COD_EMPLEADO")
	private Empleado empleado;

	//uni-directional many-to-one association to Tratamiento
	@ManyToOne
	@JoinColumn(name="COD_TRATAMIENTO", referencedColumnName="COD_TRATAMIENTO")
	private Tratamiento tratamiento;

	//uni-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="COD_ESTADO", referencedColumnName="COD_ESTADO", nullable=false)
	private Estado estado;

	//uni-directional many-to-one association to ConceptoFactura
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="COD_CONCEPTO", referencedColumnName="COD_CONCEPTO"),
		@JoinColumn(name="COD_FACTURA", referencedColumnName="COD_FACTURA")
		})
	private ConceptoFactura conceptoFactura;

	//uni-directional many-to-one association to Factura
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COD_FACTURA", referencedColumnName="COD_FACTURA", updatable=false, insertable=false)
	private Factura factura;

}