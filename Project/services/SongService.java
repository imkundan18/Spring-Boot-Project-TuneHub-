package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Song;

public interface SongService {

	public String addSong(Song songs);

	public boolean nameExist(String name);

	public List<Song> fetchAllSong();

	public void updateSong(Song song);

	

}
