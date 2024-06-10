package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class navController {
	
	@GetMapping("/map-register")
	public String registerMapping() {
		return "register";
	}
	
	@GetMapping("/map-login")
	public String loginMapping() {
		return "login";
	}
	
	@GetMapping("/map-addSongs")
		public String addSongMap() {
		return "addSongs";
	}
	
	@GetMapping("/payment")
		public String paymentment() {
			return "SamplePayment";
		}
//	@GetMapping("/Search")
//	public String showSong() {
//		return "dispalySong";
//	}
		
	

}
