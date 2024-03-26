package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;

@Controller
public class PlaylistController {
	@Autowired
	PlaylistService pserv;
	
	@Autowired
	SongService sserv;
	
	@GetMapping("/map-playlist")
	public String playlistMapping(Model model)
	{
		List<Song> list=sserv.viewAllSongs(); 
		model.addAttribute("list", list);
		return "Createplaylist";
	}
	
	@PostMapping("/createplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist)
	{
		return "playlistsuccess";
	}

}
