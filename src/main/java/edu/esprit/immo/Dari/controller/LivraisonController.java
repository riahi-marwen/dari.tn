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

import edu.esprit.immo.Dari.entities.Livraison;
import edu.esprit.immo.Dari.service.LivraisonServiceImpl;

@RestController
public class LivraisonController {

	
	@Autowired
	LivraisonServiceImpl sliv;
	
	
	@PostMapping("/addlivraison")
	public void addLivraison (@RequestBody Livraison liv ) {
		if (sliv.affectationAutoLivreur(liv.getAdresse())!= null)
		{
			liv.setLivreurs(sliv.affectationAutoLivreur(liv.getAdresse()));
			sliv.addLivraison(liv);
		}
			
		
	}
	
	@PutMapping("/updateLivraison")
	public void updateLivraison (@RequestBody Livraison liv) {
		sliv.updateLivraison(liv);
	}

	@DeleteMapping ("/deleteLivraison/{livId}")
	public void deleteLivraison (@PathVariable ("livId") int idLivraison ) {
		sliv.deleteLivraison(idLivraison);
	}
	
	@GetMapping("/retrieve-all-livraison")
	public List<Livraison> getLivraisons (){
		List<Livraison> list =sliv.retrieveAllLivraison();
		return list ;
		
	}
	
	@GetMapping ("/retrieve-livraison/{livId}")
	public Livraison retrieveLivraison (@PathVariable ("livId") String idLivraison ) {
	
		return sliv.retrievLiv(idLivraison); 
	}
	
	
	 
	
	
}

	
	