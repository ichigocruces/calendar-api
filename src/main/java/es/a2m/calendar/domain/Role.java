package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the ROLE database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="ROLE")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ROLE", nullable=false, length=6)
	private String role;

}