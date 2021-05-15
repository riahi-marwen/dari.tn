package edu.esprit.immo.Dari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.esprit.immo.Dari.entities.Livreur;
import edu.esprit.immo.Dari.repository.LivreurRepository;

@Service
public class LivreurServiceImpl implements LivreurService{

	
	@Autowired
	LivreurRepository livreurRepo ; 
	
	
	@Override
	public Livreur addLivreur(Livreur livreur) {
		livreurRepo.save(livreur);
		return livreur;
		
	}

	@Override
	public List<Livreur> retieveAllLivreur() {
		
		return (List<Livreur>) livreurRepo.findAll();
	}

	@Override
	public Livreur updateLivreur(Livreur livreur) {
		livreurRepo.save(livreur);
		return null;
	}

	

	@Override
	public void deleteLivreur(int id) {
		livreurRepo.deleteById(id);	
		
	}

	@Override
	public Livreur retieveLivreur(int id) {
		
		return livreurRepo.findById(id).orElse(null);
	}

}
