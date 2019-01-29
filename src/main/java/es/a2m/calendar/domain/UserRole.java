package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the USER_ROLE database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="USER_ROLE")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ID", nullable=false)
	private byte id;

	@Column(name="ROLE", nullable=false, length=6)
	private String role;

	@Column(name="USERNAME", nullable=false, length=25)
	private String username;

	//uni-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="COD_EMPLEADO", referencedColumnName="COD_EMPLEADO", nullable=false)
	private Empleado empleado;

}