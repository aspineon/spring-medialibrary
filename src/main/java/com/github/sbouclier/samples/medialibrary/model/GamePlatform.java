package com.github.sbouclier.samples.medialibrary.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Game platform
 * 
 * @author Stéphane Bouclier
 *
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "uk_game_platform_code", columnNames = { "code" }) })
public class GamePlatform extends PersistenceId<Integer> {

	@NotEmpty
	@Length(max=10)
	private String code;

	@NotEmpty
	private String name;

	// ----------------
	// - CONSTRUCTORS -
	// ----------------

	public GamePlatform() {
		super();
	}

	// -------------------
	// - SETTERS/GETTERS -
	// -------------------

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}
}
