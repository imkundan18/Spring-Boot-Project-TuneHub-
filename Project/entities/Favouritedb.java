package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Favouritedb {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	String email;
	
	@ManyToMany
	List<Song>song;
	public Favouritedb() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Song> getSong() {
		return song;
	}
	public void setSong(List<Song> song) {
		this.song = song;
	}
	@Override
	public String toString() {
		return "favouritedb [id=" + id + ", name=" + name + ", email=" + email + ", song=" + song + "]";
	}
	
	
	
}
