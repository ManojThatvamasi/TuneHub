package com.example.TuneHubProject.services;

import java.util.List;

import com.example.TuneHubProject.entities.Songs;

public interface SongsServices {
	public String addSongs(Songs songs);
	public boolean songExits(String name);
	public List<Songs> fetchAllSongs();
	public String updateSong(Songs song);
}
