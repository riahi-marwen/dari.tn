package edu.esprit.immo.Dari.service;

import java.util.List;

import edu.esprit.immo.Dari.entities.Intervention;


public interface InterventionService {
	public List<Intervention> retieveAllIntervention();
	public Intervention retieveIntervention (String id);
	public Intervention addIntervention (Intervention Intervention);
	public void deleteIntervention (String id); 
	public Intervention updateIntervention (Intervention Intervention); 
	public Intervention addOrUpdateIntervention (Intervention Intervention); 
}
