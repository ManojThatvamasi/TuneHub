package com.example.TuneHubProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TuneHubProject.entities.User;
import com.example.TuneHubProject.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserServices {

	@Autowired
	UserRepository UR;
	
	@Override
	public String addUser(User user) {
		UR.save(user);
		return "User is created and saved";
	}

	@Override
	public boolean emailExists(String email) {
		if(UR.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		User user=UR.findByEmail(email);
		String db_password=user.getPassword();
		if(db_password.equals(password)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public String getRole(String emial) {
		return (UR.findByEmail(emial).getRole());
	}

	@Override
	public void updateUser(User user) {
		UR.save(user);
	}

	@Override
	public User getUser(String email) {
		return UR.findByEmail(email);
	}
}
