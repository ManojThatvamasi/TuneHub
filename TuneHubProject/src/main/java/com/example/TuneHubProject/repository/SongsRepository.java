package com.example.TuneHubProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TuneHubProject.entities.Songs;

public interface SongsRepository extends JpaRepository<Songs, Integer>{
	
	public Songs findByName(String name);
}
