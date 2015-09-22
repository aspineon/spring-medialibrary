package com.github.sbouclier.samples.medialibrary.model;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Simple representation of a song
 * 
 * @author Stéphane Bouclier
 *
 */
@Entity
public class Song extends PersistenceId<Long> {

	private String title;
	private String artist;
	private String album;
	private int duration;

	// ----------------
	// - CONSTRUCTORS -
	// ----------------

	public Song(String title, String artist, String album, int duration) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.duration = duration;
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

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getAlbum() {
		return album;
	}

	public int getDuration() {
		return duration;
	}
}
