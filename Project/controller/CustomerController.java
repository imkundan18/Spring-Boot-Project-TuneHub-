package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.entities.Song;

import com.example.demo.entities.Favouritedb;
import com.example.demo.services.SongService;
import com.example.demo.services.favService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
	
	@Autowired
	favService fser;
	
	@Autowired
	SongService sserv;
	
	@GetMapping("/map-fav")
	public String addfav(Model model) {
		
		
		List<Song> songlist=sserv.fetchAllSong();
		
		//Adding the Song in Model
		model.addAttribute("songlist", songlist);
		
		//Sending CreateOlaylist
		return "addFavourite";
		
	}
	
	@PostMapping("/addfav") 
	public String addPlayList(@ModelAttribute Favouritedb favourite,HttpSession session)
	{	
		
		String email=(String) session.getAttribute("email");
		favourite.setEmail(email);
		 fser.updateUser(favourite);
		//adding PlayList
		 
		fser.addfav(favourite);
		
		
		
		//update Song  Table
		List<Song> songList=favourite.getSong();
		for(Song song :songList) {
			song.getFavouritedb().add(favourite);
			sserv.updateSong(song);
			}
		
		return "PlaylistSucess";
	}
	
	
	@GetMapping("/map-showfav")
	public String showlist(Model model,HttpSession session) {
		
		String email=(String) session.getAttribute("email");
		
		List<String> ee=new ArrayList();
				ee.add(fser.getEmail());
		for(String st:ee) {
		if(email.equals(st)) 
		{
			List<Favouritedb> flist=fser.fetchPlaylists();
		model.addAttribute("plist",flist);
		return "Showplist";
		}
		
	}
		
			return email;
		
	}

}
