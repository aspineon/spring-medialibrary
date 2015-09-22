package com.github.sbouclier.samples.medialibrary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.sbouclier.samples.medialibrary.model.User;

/**
 * UserRepository
 * 
 * @author Stéphane Bouclier
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByLastname(String lastname);
}
