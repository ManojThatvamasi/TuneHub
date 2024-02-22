package com.example.TuneHubProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TuneHubProject.entities.Playlist;
import com.example.TuneHubProject.entities.Songs;
import com.example.TuneHubProject.services.SongsServices;
import com.example.TuneHubProject.services.playlistServices;

@Controller
public class playlistController {
	
	@Autowired
	playlistServices PS;
	
	@Autowired
	SongsServices SS;
	
	@GetMapping("/map-playlist")
	public String createPlaylist(Model model) {
		 List<Songs> songsList= SS.fetchAllSongs();
		 model.addAttribute("songsList",songsList);
		 return "createPlaylist";
	}
	
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		PS.addPlaylist(playlist);

		List<Songs> songsList=playlist.getSong();
		//System.out.println(songsList);
		for(Songs songs:songsList) {
			songs.getPlaylist().add(playlist);
			SS.updateSong(songs);
		}
		return "home";
	}
	
	@GetMapping("/map-viewplaylist")
	public String viewPlayList(Model model) {
		List<Playlist> plist=PS.fetchPlaylist();
		model.addAttribute("plist",plist);
		return "viewplaylist";
	}
}
