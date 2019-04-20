package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CLIENTE database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="CLIENTE")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="COD_CLIENTE", nullable=false)
	private int codCliente;
	
	@Column(name="AFICIONES", length=2000)
	private String aficiones;

	@Lob
	@Column(name="AP_AF")
	private String apAf;

	@Column(name="APELLIDO1", nullable=false, length=50)
	private String apellido1;

	@Column(name="APELLIDO2", length=50)
	private String apellido2;

	@Column(name="CIUDAD", length=25)
	private String ciudad;

	@Column(name="COMPANIA", length=50)
	private String compania;

	@Column(name="DIRECCION", length=200)
	private String direccion;

	@Column(name="DNI", length=10)
	private String dni;

	@Lob
	@Column(name="EDTE")
	private String edte;

	@Column(name="EMAIL", length=200)
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FH_BAJA")
	private Date fhBaja;

	@Temporal(TemporalType.DATE)
	@Column(name="FH_NACIMIENTO")
	private Date fhNacimiento;

	@Column(name="FISICO_JURIDICO", length=1)
	private String fisicoJuridico;

	@Column(name="NOMBRE", nullable=false, length=20)
	private String nombre;

	@Column(name="PROFESION", length=50)
	private String profesion;

	@Column(name="TELEFONO1", nullable=false)
	private int telefono1;

	@Column(name="TELEFONO2")
	private int telefono2;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="cliente")
	private List<Documento> documentos;

}