package com.github.sbouclier.samples.medialibrary.service;

import java.util.List;

import com.github.sbouclier.samples.medialibrary.model.Media;

/**
 * MediaService
 * 
 * @author Stéphane Bouclier
 *
 */
public interface MediaService {

	/**
	 * Persist a media
	 * 
	 * @param media
	 */
	void persist(Media media);

	/**
	 * Retrieve all medias
	 * 
	 * @return medias
	 */
	List<Media> getAll();
}
