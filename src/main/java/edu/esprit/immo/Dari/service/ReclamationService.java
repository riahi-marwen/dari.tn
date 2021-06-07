package edu.esprit.immo.Dari.service;

import java.util.List;

import edu.esprit.immo.Dari.entities.Reclamation;

public interface ReclamationService {

	public List<Reclamation> retieveAllReclamation();
	public Reclamation retieveReclamation (String id);
	public Reclamation addReclamation (Reclamation Reclamation);
	public void deleteReclamation (String id); 
	public Reclamation updateReclamation (Reclamation Reclamation); 
	public Reclamation addOrUpdateReclamation (Reclamation Reclamation); 


}
