package edu.esprit.immo.Dari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.esprit.immo.Dari.entities.Livraison;
import edu.esprit.immo.Dari.entities.Livreur;
import edu.esprit.immo.Dari.entities.Secteur;
import edu.esprit.immo.Dari.repository.LivraisonRepository;

@Service
public class LivraisonServiceImpl implements LivraisonService {
	
	@Autowired 
	LivraisonRepository LivRepo ; 

	@Override
	public Livraison addLivraison(Livraison liv) {

		LivRepo.save(liv); 
		return liv;
	}
 
	public Livreur affectationAutoLivreur (Secteur adresse) {
	 
		return LivRepo.getcode(adresse);
		
	}
	
	@Override
	public List<Livraison> retrieveAllLivraison() {
		 
		return (List<Livraison>) LivRepo.findAll();
		
	}

	@Override
	public Livraison updateLivraison(Livraison liv) {
		LivRepo.save(liv); 
		return null;
	}

	@Override
	public void deleteLivraison(int id) {
		LivRepo.deleteById(id) ; 
	}

	@Override
	public Livraison retrievLiv(String id) {
		// TODO Auto-generated method stub
		return LivRepo.findById(Integer.parseInt(id)).orElse(null);
	}

}
