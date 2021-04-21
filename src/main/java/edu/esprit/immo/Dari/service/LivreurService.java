package edu.esprit.immo.Dari.service;

import java.util.List;

import edu.esprit.immo.Dari.entities.Livreur;

public interface LivreurService {
	
	public Livreur addLivreur (Livreur livreur);
	public List<Livreur> retieveAllLivreur(); 
	public Livreur updateLivreur (Livreur livreur); 
	public void deleteLivreur (String id); 
	public Livreur retieveLivreur (String id);

}
