package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.entities.Users;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PlaylistController {
	
	@Autowired
	PlaylistService pserv;
	
	@Autowired
	SongService sserv;
	
	@Autowired
	UsersService userv;
	
	@GetMapping("/map-playlist")
	public String createPlayList(Model model) {
	
		//Fetching Song using Song Service
		List<Song> songlist=sserv.fetchAllSong();
		
		//Adding the Song in Model
		model.addAttribute("songlist", songlist);
		
		//Sending CreateOlaylist
		return "createPlaylist";
	}
	
	@PostMapping("/addPlaylist") 
	public String addPlayList(@ModelAttribute Playlist playlist)
	{	
		//adding PlayList
		pserv.addPlayList(playlist);
		
		//update Song  Table
		List<Song> songList=playlist.getSong();
		for(Song song :songList) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
			}
		
		return "PlaylistSucess";
	}
	@GetMapping("/map-showPlaylist")
	public String showplist(Model model) {
		
		List<Playlist> plist=pserv.fetchPlaylists();
		model.addAttribute("plist",plist);
		//System.out.print(plist);
		return "Showplist";
	}
	
	@GetMapping("/customerPlaylist")
     public String customerplist(HttpSession session,Model model) {
		
		String email=(String) session.getAttribute("email");
		Users user=userv.getUser(email);
		boolean status=user.isPremium();
		if(status==true) {
		List<Playlist> plist=pserv.fetchPlaylists();
		model.addAttribute("plist",plist);
		//System.out.print(plist);
		return "Showplist";
		}
		else {
			return "SamplePayment";
		}
	}
	
	

}
