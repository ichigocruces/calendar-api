package es.a2m.calendar.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the USER database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="USER")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ENABLED", nullable=false)
	private byte enabled;

	@Column(name="PASSWORD", nullable=false, length=25)
	private String password;

	//uni-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="USER_ROLE"
		, joinColumns={
			@JoinColumn(name="USERNAME", referencedColumnName="USERNAME", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="ROLE", referencedColumnName="ROLE", nullable=false)
			}
		)
	private List<Role> roles;

}