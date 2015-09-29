package com.github.sbouclier.samples.medialibrary.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sbouclier.samples.medialibrary.model.Media;
import com.github.sbouclier.samples.medialibrary.repository.MediaRepository;

/**
 * Default {@link MediaService} implementation
 * 
 * @author Stéphane Bouclier
 *
 */
@Service
public class DefaultMediaService implements MediaService {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultMediaService.class);

	@Autowired
	MediaRepository mediaRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void persist(Media media) {
		LOG.debug("persist(media={})", media);
		mediaRepository.save(media);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
    public List<Media> getAll() {
	    return (List<Media>) mediaRepository.findAll();
    }
}
