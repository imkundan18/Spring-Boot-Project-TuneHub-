package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Favouritedb;

public interface favService {

	void addfav(Favouritedb favourite);


	void updateUser(Favouritedb favourite);


	public List<Favouritedb> fetchPlaylists();


	public String getEmail();




	

}
