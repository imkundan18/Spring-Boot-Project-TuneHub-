package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	String artist;
	String genre;
	String link;
	@ManyToMany
	List<Playlist>playlist;
	
	@ManyToMany
	List<Favouritedb> favouritedb;
	
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}

	public List<Favouritedb> getFavouritedb() {
		return favouritedb;
	}

	public void setFavouritedb(List<Favouritedb> favouritedb) {
		this.favouritedb = favouritedb;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link
				+ ", playlist=" + playlist + ", favouritedb=" + favouritedb + "]";
	}
	
	

}
