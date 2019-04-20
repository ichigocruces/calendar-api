package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * The persistent class for the DOCUMENTO database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="DOCUMENTO")
@NamedQuery(name="Documento.findAll", query="SELECT d FROM Documento d")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="COD_DOCUMENTO", nullable=false)
	private int codDocumento;
	
	@Lob
	@Column(name="DOCUMENTO")
	private byte[] documento;

	@Temporal(TemporalType.DATE)
	@Column(name="FH_MODIFICACION")
	private Date fhModificacion;

	@Column(name="NOMBRE", nullable=false, length=50)
	private String nombre;

	@Column(name="NOMBRE_FICHERO", length=200)
	private String nombreFichero;

	@Column(name="TAMANO")
	private int tamano;

	@Column(name="TIPO", nullable=false, length=6)
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="COD_CLIENTE", referencedColumnName="COD_CLIENTE", nullable=false)
	private Cliente cliente;

}