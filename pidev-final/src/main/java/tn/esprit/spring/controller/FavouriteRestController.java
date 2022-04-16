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

import tn.esprit.spring.entities.Favourite;
import tn.esprit.spring.services.IFavouriteService;



@RestController
public class FavouriteRestController 
{
	
	@Autowired
	IFavouriteService ifav ; 
	
	@PostMapping("/addfavourite")
	public String AjouterFavourite(@RequestBody Favourite favourite) {
		return ifav.AjouterFavourite(favourite);
}
	@GetMapping("/retrieve-all-favourites")
	@ResponseBody
	public List<Favourite> getProperty() {
	List<Favourite> list = ifav.getAllContrats(); 
	return list;
	}
	
	//        retourner list favourite 
	@GetMapping("/retrieve-all-favourite")
	@ResponseBody
	public List<Favourite> getBuy() {
	List<Favourite> list = ifav.getAllContrats(); 
	return list;
	}
	
	//        supprimer favourite     
	
	@DeleteMapping("/deleteFavouriteById/{iddept}") 
	@ResponseBody
	public void deletePropertyById(@PathVariable("iddept") int depId) {
		ifav.deletePropertyById(depId);
	}
	

}
