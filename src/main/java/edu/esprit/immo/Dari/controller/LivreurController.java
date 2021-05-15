package edu.esprit.immo.Dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.esprit.immo.Dari.entities.Livreur;
import edu.esprit.immo.Dari.service.LivreurServiceImpl;

@RestController
public class LivreurController {

	@Autowired
	LivreurServiceImpl slivr ; 
	
	@PostMapping("/addLivreur")
	public void addlivreur (@RequestBody Livreur livreur) {
		slivr.addLivreur(livreur);
		
	}
	
	@PutMapping ("/updateLivreur")
	public void updateLivreur (@RequestBody Livreur livreur)
	{
		slivr.updateLivreur(livreur);
	}
	
	/*
	 * @DeleteMapping("/deleteLivreur/{lrId}") public void deleteLivreur
	 * (@PathVariable ("lrId") int idLivreur ) {
	 * 
	 * slivr.deleteLivreur(idLivreur); }
	 */
	
	@GetMapping("/retrieve-all-livreur")
	public List<Livreur> getLivreurs (){
		List<Livreur> list =slivr.retieveAllLivreur();
		return list ;
	}
	
	@GetMapping("retrieve-livreur/{lrId}")
	public Livreur retrieveLivreur (@PathVariable ("lrId") int idLivreur ) {
		return slivr.retieveLivreur(idLivreur);
	}
	
	
}

