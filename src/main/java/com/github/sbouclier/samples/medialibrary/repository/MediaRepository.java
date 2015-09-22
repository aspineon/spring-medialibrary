package com.github.sbouclier.samples.medialibrary.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.sbouclier.samples.medialibrary.model.Media;

/**
 * MediaRepository
 * 
 * @author Stéphane Bouclier
 *
 */
public interface MediaRepository extends CrudRepository<Media, Long> {

}
