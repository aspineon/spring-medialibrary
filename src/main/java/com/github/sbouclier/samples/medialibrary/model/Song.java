package com.github.sbouclier.samples.medialibrary.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.ForeignKey;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Simple representation of a song
 * 
 * @author Stéphane Bouclier
 *
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "uk_song", columnNames = { "cd_id",
        "position" }) })
public class Song extends PersistenceId<Long> {

	@ManyToOne
	//@ForeignKey(name = "fk_song_cd")
	  @JoinColumn(foreignKey = @ForeignKey(name = "fk_song_cd"))
	private CD cd;

	private String title;
	private byte position;
	private short duration;

	// ----------------
	// - CONSTRUCTORS -
	// ----------------

	public Song() {
	    super();
    }
	
	public Song(String title, byte position, short duration) {
		super();
		this.title = title;
		this.position = position;
		this.duration = duration;
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

	public String getTitle() {
		return title;
	}

	public byte getPosition() {
		return position;
	}

	public short getDuration() {
		return duration;
	}

}
