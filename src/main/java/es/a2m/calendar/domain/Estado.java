package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the ESTADO database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="ESTADO")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="COD_ESTADO", nullable=false)
	private byte codEstado;

	@Column(name="DESCRIPCION", nullable=false, length=50)
	private String descripcion;

}