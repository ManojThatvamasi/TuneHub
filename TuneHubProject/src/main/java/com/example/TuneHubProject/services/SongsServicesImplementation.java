package com.example.TuneHubProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TuneHubProject.entities.Songs;
import com.example.TuneHubProject.repository.SongsRepository;

@Service
public class SongsServicesImplementation implements SongsServices{

	@Autowired
	SongsRepository SR;
	
	@Override
	public String addSongs(Songs songs) {
		SR.save(songs);
		return "Songs are created and saved";
	}

	@Override
	public boolean songExits(String name) {
		Songs song=SR.findByName(name);
		if(song==null) {
		return false;
		}
		else 
		{
		return true;
		}	
	}

	@Override
	public List<Songs> fetchAllSongs() {
		List<Songs> list=SR.findAll();
		return list;
	}

	@Override
	public String updateSong(Songs song) {
		SR.save(song);
		return "Song Updated and saved";
	}
}	
