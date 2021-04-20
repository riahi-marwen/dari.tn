package edu.esprit.immo.Dari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		sliv.addLivraison(liv);
		
	}

}
