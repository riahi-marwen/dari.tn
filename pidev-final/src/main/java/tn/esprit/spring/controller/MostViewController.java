package tn.esprit.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.MostView;
import tn.esprit.spring.services.IMostViewService;



@RestController
public class MostViewController
{
	@Autowired
	IMostViewService imost; 
	@PostMapping("/addMostView")
	public int  AjouterFavourite(@RequestBody MostView mostView) 
	{
		return imost.AjouterMostView(mostView);
	}
	@GetMapping("/retrieve-all-mostview")
	@ResponseBody
	public List<MostView> getProperty() {
	List<MostView> list = imost.remplirMostView(); 
	return list;
	}
	@GetMapping("/retrieve-allmostview")
	@ResponseBody
	public List<MostView> getAllmostView() {
	List<MostView> list = imost.getAllMostView(); 
	return list;
	}
	
	//        supprimer MostView      
	
	@DeleteMapping("/deleteMostViewById/{iddept}") 
	@ResponseBody
	public void deletePropertyById(@PathVariable("iddept") int depId) {
		imost.deleteMostViewById(depId);
	}	
	
}

