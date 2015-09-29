package com.github.sbouclier.samples.medialibrary.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Game entity
 * 
 * @author Stéphane Bouclier
 *
 */
@Entity
public class Game extends Media {

	@ManyToMany(fetch=FetchType.EAGER)
	private List<GamePlatform> platforms;

	@NotNull
	@Enumerated(EnumType.STRING)
	private GamePegi pegi;

	// ----------------
	// - CONSTRUCTORS -
	// ----------------

	public Game() {
		super();
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

	public GamePegi getPegi() {
		return pegi;
	}

	public List<GamePlatform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<GamePlatform> platforms) {
		this.platforms = platforms;
	}

	public void setPegi(GamePegi pegi) {
		this.pegi = pegi;
	}
}