package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;

@Service
public class SongServiceImplementation implements SongService{

	@Autowired
	SongRepository srepo;
	
	@Override
	public String addSong(Song song) {
		srepo.save(song);
		return "Song is added succesfully";
	}

	@Override
	public boolean songExist(String name) {
		Song song=srepo.findByName(name);
		if(song==null)
		{
			return false;
		}
		return true;
	}

	@Override
	public List<Song> viewAllSongs() {
		List<Song> list=srepo.findAll();
		return list;
	}

}
