package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Favouritedb;

public interface favRepositrey extends JpaRepository<Favouritedb,Integer>{

	public Favouritedb findByEmail(String Email);

	//public String getEmail();

}
