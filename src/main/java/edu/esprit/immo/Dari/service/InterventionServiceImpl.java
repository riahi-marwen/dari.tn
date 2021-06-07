package edu.esprit.immo.Dari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.esprit.immo.Dari.entities.Intervention;
import edu.esprit.immo.Dari.repository.InterventionRepository;

@Service
public class InterventionServiceImpl implements InterventionService {
	
	@Autowired
	InterventionRepository InterventionRepository;
	
	@Override
	public List<Intervention> retieveAllIntervention() {
		return (List<Intervention>) InterventionRepository.findAll();
	}

	@Override
	public Intervention retieveIntervention(String id) {
		return InterventionRepository.findById(Long.parseLong(id)).orElse(null);
	}

	@Override
	public Intervention addIntervention(Intervention Intervention) {
		InterventionRepository.save(Intervention);
		return Intervention;
	}

	@Override
	public void deleteIntervention(String id) {
		InterventionRepository.deleteById(Long.parseLong(id));		
	}

	@Override
	public Intervention updateIntervention(Intervention Intervention) {
		InterventionRepository.save(Intervention);
		return Intervention;
	}

	@Override
	public Intervention addOrUpdateIntervention(Intervention Intervention) {
		InterventionRepository.save(Intervention);
		return Intervention;
	}
	
	
	

}
