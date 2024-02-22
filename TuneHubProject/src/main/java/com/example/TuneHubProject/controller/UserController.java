package com.example.TuneHubProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.*;

import com.example.TuneHubProject.entities.Songs;
import com.example.TuneHubProject.entities.User;
import com.example.TuneHubProject.services.SongsServices;
import com.example.TuneHubProject.services.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserServices US;
	@Autowired
	SongsServices SS;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {
		if( US.emailExists(user.getEmail())== false) {
			US.addUser(user);
			return "registersuccess";
		}
		else {
			return "registerfail";
		}
	}
	
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password, HttpSession session) {
		if(US.validateUser(email, password) == true) {
			session.setAttribute("email", email);
			if(US.getRole(email).equals("admin"))
				return "adminHome";
			else
				return "customerHome";	
			}
		else {
			return "loginfail";
		}
	}
	
	@GetMapping("/map-customerviewsongs")
	public String customerViewSongs(HttpSession session, Model model) {
		String email=(String)session.getAttribute("email");
		User user=US.getUser(email);
	
		boolean userStatus=user.isPremium();
		if(userStatus==true) {
			List<Songs> songsList= SS.fetchAllSongs();
			model.addAttribute("songsList",songsList);
			return "viewsongs";
		}
		else {
			return "makePayment";
		}
	}
}


