package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;

@Service
public class SongServiceImplemention implements SongService {
	
	@Autowired
	SongRepository repo;

	@Override
	public String addSong(Song songs) {
		repo.save(songs);
		return "Song added";
		
		
	}

	@Override
	public boolean nameExist(String name) {
		Song exist=repo.findByName(name);
		if(exist==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<Song> fetchAllSong() {
		List<Song> songlist=repo.findAll();
		return songlist;
	}

	@Override
	public void updateSong(Song song) {
		repo.save(song);
		
	}

}
