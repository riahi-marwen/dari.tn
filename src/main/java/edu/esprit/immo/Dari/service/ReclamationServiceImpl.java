package edu.esprit.immo.Dari.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.esprit.immo.Dari.entities.Reclamation;
import edu.esprit.immo.Dari.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements ReclamationService {
@Autowired
	ReclamationRepository ReclamationRepository;
	@Override
	public List<Reclamation> retieveAllReclamation() {
		return (List<Reclamation>) ReclamationRepository.findAll();
	}

	@Override
	public Reclamation retieveReclamation(String id) {
		return ReclamationRepository.findById(Long.parseLong(id)).orElse(null);
	}

	@Override
	public Reclamation addReclamation(Reclamation Reclamation) {
		ReclamationRepository.save(Reclamation);
		return Reclamation;
	}

	@Override
	public void deleteReclamation(String id) {
		ReclamationRepository.deleteById(Long.parseLong(id));		
	}

/*	@Override
	public Reclamation updateReclamation(Reclamation Reclamation) {
		ReclamationRepository.save(Reclamation);
		return Reclamation;
	}*/
	
	
	@Override
	public Reclamation addOrUpdateReclamation(Reclamation reclamation) {
	ReclamationRepository.save(reclamation);
	return reclamation;
	}

	@Override
	public List<Reclamation> getReclamationByCode(String codepostal) {
		return ReclamationRepository.getReclamationByCode(codepostal);
	}

	@Override
	public Reclamation updateReclamation(Reclamation Reclamation) {
		ReclamationRepository.save(Reclamation);
		return Reclamation;
	}

	@Override
	public void updateReclamation2(Long id, String civilite, String nom, String prenom, String email, String tele,
		String address, String codepostal, String ville, String description, String comments) {
	Reclamation rec  = ReclamationRepository.findById(id).get();
	rec.setCivilite(civilite);
	rec.setNom(nom);
	rec.setPrenom(prenom);
	rec.setEmail(email);
	rec.setTele(tele);
	rec.setAddress(address);
	rec.setCodepostal(codepostal);
	rec.setVille(ville);
	rec.setDescription(description);
	rec.setComments(comments);

	ReclamationRepository.save(rec);	
}

	@Override
	public String updateReclamation3(Reclamation reclamation) {
		ReclamationRepository.save(reclamation);
		 return "valid";
	}

	@Override
	public Reclamation updateReclamation4(long id, Reclamation rec) {
		Reclamation recl=ReclamationRepository.findById(id).get();
		recl.setCivilite(rec.getCivilite());
		recl.setNom(rec.getNom());
		recl.setPrenom(rec.getPrenom());
		recl.setEmail(rec.getEmail());
		recl.setTele(rec.getTele());
		recl.setAddress(rec.getAddress());
		recl.setCodepostal(rec.getCodepostal());
		recl.setVille(rec.getVille());
		recl.setDescription(rec.getDescription());
		recl.setComments(rec.getComments());
		ReclamationRepository.save(recl);
		return recl;
	}
	

 
	
}
