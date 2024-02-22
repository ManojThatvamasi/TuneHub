package com.example.TuneHubProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TuneHubProject.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
}
