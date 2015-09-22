package com.github.sbouclier.samples.medialibrary.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.ForeignKey;

/**
 * DVD entity
 * 
 * @author Stéphane Bouclier
 *
 */
@Entity
public class DVD extends Media {

	@ElementCollection
	@ForeignKey(name = "fk_dvd_actor")
	private List<String> actors = new ArrayList<String>();

	private int year;

	// ----------------
	// - CONSTRUCTORS -
	// ----------------

	public DVD() {
		super();
	}

	// -----------
	// - METHODS -
	// -----------

	public void addActor(String actor) {
		this.actors.add(actor);
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

	public List<String> getActors() {
		return Collections.unmodifiableList(actors);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
