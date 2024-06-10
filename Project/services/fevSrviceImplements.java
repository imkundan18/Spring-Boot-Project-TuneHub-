package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Favouritedb;

import com.example.demo.repositories.favRepositrey;

@Service
public class fevSrviceImplements implements favService {

	@Autowired
	favRepositrey frepo;
	
	@Override
	public void addfav(Favouritedb favourite) {
		frepo.save(favourite);
		
	}

	@Override
	public void updateUser(Favouritedb favourite) {
		frepo.save(favourite);
		
	}

	@Override
	public List<Favouritedb> fetchPlaylists() {
		List<Favouritedb> plist=frepo.findAll();
		return plist;
	}

	@Override
	public String getEmail() {
		Favouritedb favourite=frepo.findByEmail(getEmail());
		return favourite.getEmail();
	}






	

}
