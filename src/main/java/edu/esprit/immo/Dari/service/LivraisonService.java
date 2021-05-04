package edu.esprit.immo.Dari.service;

import java.util.List;

import edu.esprit.immo.Dari.entities.Livraison;

public interface LivraisonService {
	
	
	public Livraison addLivraison (Livraison liv); 
	public List<Livraison> retrieveAllLivraison (); 
	public Livraison updateLivraison (Livraison liv) ; 
	public void deleteLivraison (String id); 
	public Livraison retrievLiv (String id) ; 

}
