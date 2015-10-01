package com.github.sbouclier.samples.medialibrary.service;

import java.util.List;

import com.github.sbouclier.samples.medialibrary.model.CD;
import com.github.sbouclier.samples.medialibrary.model.DVD;
import com.github.sbouclier.samples.medialibrary.model.Game;
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

	/**
	 * Retrieve all CDs
	 * 
	 * @return CDs
	 */
	List<CD> getAllMediaCD();
	
	/**
	 * Retrieve all DVDs
	 * 
	 * @return DVDs
	 */
	List<DVD> getAllMediaDVD();
	
	/**
	 * Retrieve all games
	 * 
	 * @return games
	 */
	List<Game> getAllMediaGame();
}
