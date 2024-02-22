package com.example.TuneHubProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NaviController {
	
	@GetMapping("/map-register")
	public String registerMap(){
		return "register";
	}
	
	@GetMapping("/map-login")
	public String loginMap(){
		return "login";
	}
	
	@GetMapping("/map-songs")
	public String songsMap() {
		return "addSongs";
	}
	
	@GetMapping("/makePayment")
	public String samplePayment() {
		return "makePayment";
	}
}
