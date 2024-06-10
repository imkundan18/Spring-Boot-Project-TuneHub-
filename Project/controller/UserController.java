package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Song;
import com.example.demo.entities.Users;
import com.example.demo.services.SongService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UsersService userv;
	
	@Autowired
	SongService serv;

	
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user)					
	{	
		boolean userstatus = userv.emailExits(user.getEmail());
		
		if(userstatus==false)
		{
		userv.addUser(user);
		//System.out.println("User is added");
		return "registerSucess";
		}
		else {
			System.out.println("User id already exist");
			return "registerFail";
		}
		//return "Home";
	}
	
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session) {
		boolean loginStatus=userv.validateUser(email, password);
		if(loginStatus==true)
		{
			session.setAttribute("email", email);//Add Session
			String role=userv.getRole(email);
			if(role.equals("admin")) {
			return "adminHome";
			}else {
			return "customerHome";
			}
		}
		else {
			return "loginFail";
		}
	}
	@GetMapping("/exploreSong")
		public String exploreSong(HttpSession session,Model model) {
		
		String email=(String) session.getAttribute("email");
		
		Users user=userv.getUser(email);
		boolean userStatus=user.isPremium();
		if(userStatus==true) {
			List<Song>songlist =serv.fetchAllSong();
			model.addAttribute("songlist", songlist);
	
			return "dispalySong";
		}else {
			return "MakePayment";
		}
	}
	
	
}
