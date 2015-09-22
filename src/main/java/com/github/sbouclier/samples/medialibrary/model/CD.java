package com.github.sbouclier.samples.medialibrary.model;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * CD entity
 * 
 * @author Stéphane Bouclier
 *
 */
@Entity
public class CD extends Media {

	@OneToMany
	protected Set<Song> songs;
	
	// ----------------
	// - CONSTRUCTORS -
	// ----------------
	
	public CD() {
		super();
	}

	// -----------
	// - METHODS -
	// -----------

	public void addSong(Song song) {
		this.songs.add(song);
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

	public Set<Song> getSongs() {
		return Collections.unmodifiableSet(songs);
	}
}
