package com.github.sbouclier.samples.medialibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.github.sbouclier.samples.medialibrary.model.CD;
import com.github.sbouclier.samples.medialibrary.model.DVD;
import com.github.sbouclier.samples.medialibrary.model.Game;
import com.github.sbouclier.samples.medialibrary.model.Media;

/**
 * MediaRepository
 * 
 * @author Stéphane Bouclier
 *
 */
public interface MediaRepository extends CrudRepository<Media, Long> {

	@Query("select c from CD c")
	List<CD> findAllMediaCD();

	@Query("select d from DVD d")
	List<DVD> findAllMediaDVD();

	@Query("select g from Game g")
	List<Game> findAllMediaGame();
}
