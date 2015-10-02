package com.github.sbouclier.samples.medialibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.sbouclier.samples.medialibrary.service.MediaService;

/**
 * MediaController
 * 
 * @author Stéphane Bouclier
 *
 */
@Controller
@RequestMapping("/media")
public class MediaController {

	@Autowired
	MediaService mediaService;

	@RequestMapping("/cd")
	public String cd(Model model) {
		model.addAttribute("cd", mediaService.getAllMediaCD());

		return "media/cd";
	}
	
	@RequestMapping("/dvd")
	public String dvd(Model model) {
		model.addAttribute("dvd", mediaService.getAllMediaDVD());

		return "media/dvd";
	}
	
	@RequestMapping("/game")
	public String game(Model model) {
		model.addAttribute("game", mediaService.getAllMediaGame());

		return "media/game";
	}
}
