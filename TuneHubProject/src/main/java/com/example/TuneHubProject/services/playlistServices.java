package com.example.TuneHubProject.services;

import java.util.List;

import com.example.TuneHubProject.entities.Playlist;

public interface playlistServices {
	public String addPlaylist(Playlist playlist);
	public List<Playlist> fetchPlaylist();
}
