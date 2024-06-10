package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepositrey;

@Service
public class playListServiceImplementation implements PlaylistService {

	
	@Autowired
	PlaylistRepositrey prepo;

	@Override
	public void addPlayList(Playlist playlist) {
		prepo.save(playlist);
		
	}

	@Override
	public List<Playlist> fetchPlaylists() {
		List<Playlist> plist=prepo.findAll();
		return plist;
	}
	
}
