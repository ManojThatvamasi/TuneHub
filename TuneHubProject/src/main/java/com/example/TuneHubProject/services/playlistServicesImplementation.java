package com.example.TuneHubProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TuneHubProject.entities.Playlist;
import com.example.TuneHubProject.repository.playlistRepository;

@Service
public class playlistServicesImplementation implements playlistServices{
	@Autowired
	playlistRepository PR;

	@Override
	public String addPlaylist(Playlist playlist) {
		PR.save(playlist);
		return "Playlist created and Saved";
	}

	@Override
	public List<Playlist> fetchPlaylist() {
		// TODO Auto-generated method stub
		return PR.findAll();
	}
}
