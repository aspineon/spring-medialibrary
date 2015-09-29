package com.github.sbouclier.samples.medialibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.sbouclier.samples.medialibrary.repository.UserRepository;
import com.github.sbouclier.samples.medialibrary.service.MediaService;

/**
 * HomeController
 * 
 * @author Stéphane Bouclier
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	MediaService mediaService;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("medias", mediaService.getAll());

		return "home";
	}
}
