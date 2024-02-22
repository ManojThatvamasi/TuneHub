package com.example.TuneHubProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.*;

import com.example.TuneHubProject.entities.Songs;
import com.example.TuneHubProject.services.SongsServices;


@Controller
public class SongsController {
	@Autowired
	SongsServices SS;
	
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Songs songs) {
		if( SS.songExits(songs.getName())== false) {
			SS.addSongs(songs);
			return "songsuccess";
		}
		else {
			return "songfails";
		}
	}
	
	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model) {
	 List<Songs> songsList= SS.fetchAllSongs();
	 model.addAttribute("songsList",songsList);
	 return "viewsongs";
	}	
	
//	@GetMapping("/map-customerviewsongs")
//	public String customerViewSongs(Model model) {
//		boolean primeStatus=false;
//		if(primeStatus==true) 
//		{
//			 List<Songs> songsList= SS.fetchAllSongs();
//			 model.addAttribute("songsList",songsList);
//			 return "viewsongs";
//		 }
//		else
//		{
//			return "makePayment";
//		}
//	}
}