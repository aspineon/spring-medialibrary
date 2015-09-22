package com.github.sbouclier.samples.medialibrary.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Abstract class for storing medias
 * 
 * @author Stéphane Bouclier
 *
 */
@Entity(name = "media")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Media extends PersistenceId<Long> {

	@NotEmpty
	protected String title;

	@NotNull
	protected Date createdDate;

	protected Date updatedDate;

	// ----------------
	// - CONSTRUCTORS -
	// ----------------

	public Media() {
		createdDate = new Date();
	}

	// -----------
	// - METHODS -
	// -----------

	/**
	 * 
	 * @return name of media subclass
	 */
	public String getType() {
		return this.getClass().getSimpleName().toLowerCase();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedDate() {
		return new Date(createdDate.getTime());
	}

	public Date getUpdatedDate() {
		return new Date(updatedDate.getTime());
	}
}