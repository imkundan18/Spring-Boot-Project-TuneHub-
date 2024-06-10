package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Song;
import com.example.demo.entities.Users;
import com.example.demo.services.SongService;
import com.example.demo.services.UsersService;

@Controller
public class SongsController {
	
	@Autowired
	SongService asong;
	
	@Autowired
	UsersService services;
	
	@PostMapping("/addSongs")
	public String addSong(@ModelAttribute Song songs) {
		boolean status=asong.nameExist(songs.getName());
		
		if(status==false) {
		asong.addSong(songs);
		return "SongAdd";
	}
	else {
		System.out.println("Alreadey Song Present");
		return "Alreadey Song Present";
	}
	}
	
	@GetMapping("/map-showSong")
	
	public String viewSong(Model model)
	{
		List<Song>songlist =asong.fetchAllSong();
		//System.out.println(songlist);
		model.addAttribute("songlist", songlist);
		return "dispalySong";
	}
	
//	@GetMapping("/Map-CustomerView")
//	public String viewCustomerSong(Model model, boolean isPremium) {
//		boolean primeCustomerStatus=true;
//		//boolean primeCustomerStatus=services.setpremium(isPremium);
//		if(primeCustomerStatus==true) {
//			
//			List<Song>songlist =asong.fetchAllSong();
//			model.addAttribute("songlist", songlist);
//			return "dispalySong";
//			
//		}else
//		{
//			return "MakePayment";
//		}
//		
//		
//	}
//	

}
