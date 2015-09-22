package com.github.sbouclier.samples.medialibrary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User entity
 * 
 * @author Stéphane Bouclier
 *
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "uk_user_username", columnNames = { "username" }) })
public class User extends PersistenceId<Long> {

	@NotEmpty
	@Column(length = 20)
	private String username;

	@NotEmpty
	@Column(length = 50)
	private String password;

	@NotEmpty
	@Column(length = 50)
	private String firstname;

	@NotEmpty
	@Column(length = 50)
	private String lastname;

	// ----------------
	// - CONSTRUCTORS -
	// ----------------

	protected User() {
	}

	public User(String username, String password, String firstname, String lastname) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	// -------------
	// - TO STRING -
	// -------------

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	// -------------------
	// - SETTERS/GETTERS -
	// -------------------

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

}
