package com.github.sbouclier.samples.medialibrary.model;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * CD entity
 * 
 * @author Stéphane Bouclier
 *
 */
@Entity
public class CD extends Media {

	private int year;

	private String artist;

	@OneToMany(mappedBy="cd")
	protected List<Song> songs;

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
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	// -------------------
	// - SETTERS/GETTERS -
	// -------------------

	public List<Song> getSongs() {
		return Collections.unmodifiableList(songs);
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public String getArtist() {
		return artist;
	}
}
