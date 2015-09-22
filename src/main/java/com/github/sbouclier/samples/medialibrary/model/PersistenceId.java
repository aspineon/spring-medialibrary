package com.github.sbouclier.samples.medialibrary.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Generic persistent ID class
 * 
 * @author Stéphane Bouclier
 *
 * @param <T>
 */
@MappedSuperclass
public class PersistenceId<T> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected T id;

	// ----------------
	// - CONSTRUCTORS -
	// ----------------

	public PersistenceId() {

	}

	public PersistenceId(T id) {
		this.id = id;
	}

	// -------------------
	// - EQUALS/HASHCODE -
	// -------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersistenceId<T> other = (PersistenceId<T>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// -------------
	// - TO STRING -
	// -------------

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).toString();
	}

	// -------------------
	// - SETTERS/GETTERS -
	// -------------------

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
}
