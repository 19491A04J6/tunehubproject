package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

@Controller
public class SongsController {
	
	@Autowired
	SongService sserv;
	
	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song)
	{
		boolean songstatus=sserv.songExist(song.getName());
		if(songstatus==false)
		{
			sserv.addSong(song);
		    return "SongSuccessful";
		}
		return "SongFail";
	}
    
	@GetMapping("/map-allsongs")
	public String viewAllSongs(Model model)
	{
		List<Song> list=sserv.viewAllSongs();
		model.addAttribute("list", list);
		return "DisplaySongs";
	}
	
	@GetMapping("/viewsong")
	public String viewSong(Model model)
	{
		boolean paymentStatus=true;
		if(paymentStatus==true)
		{
			List<Song> list=sserv.viewAllSongs();
			model.addAttribute("list", list);
			return "viewSong";
		}
		return "makePayment";
	}
}
