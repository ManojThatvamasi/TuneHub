package com.example.TuneHubProject.services;

import com.example.TuneHubProject.entities.User;

public interface UserServices {

	public String addUser(User user);
	public boolean emailExists(String email);
	public boolean validateUser(String email,String password);
	public String getRole(String emial);
	public void updateUser(User user);
	public User getUser(String email);	
}
