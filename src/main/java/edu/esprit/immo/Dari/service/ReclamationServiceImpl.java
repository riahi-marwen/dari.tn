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

	@Override
	public Reclamation updateReclamation(Reclamation Reclamation) {
		ReclamationRepository.save(Reclamation);
		return Reclamation;
	}
	
	@Override
	public Reclamation addOrUpdateReclamation(Reclamation reclamation) {
	ReclamationRepository.save(reclamation);
	return reclamation;
	}
 
	
}
