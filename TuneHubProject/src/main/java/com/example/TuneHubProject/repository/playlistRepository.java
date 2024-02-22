package com.example.TuneHubProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TuneHubProject.entities.Playlist;

public interface playlistRepository extends JpaRepository<Playlist, Integer>{

}
