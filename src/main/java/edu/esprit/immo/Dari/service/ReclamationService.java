package edu.esprit.immo.Dari.service;

import java.util.List;

import edu.esprit.immo.Dari.entities.Reclamation;

public interface ReclamationService {

	public List<Reclamation> retieveAllReclamation();
	public Reclamation retieveReclamation (String id);
	public Reclamation addReclamation (Reclamation Reclamation);
	public void deleteReclamation (String id); 
	public Reclamation updateReclamation (Reclamation Reclamation); 
	public void updateReclamation2(Long id, String civilite, String nom, String prenom, String email, String tele, String address, String codepostal, String ville, String description, String comments );
	public Reclamation addOrUpdateReclamation (Reclamation Reclamation); 
	public List<Reclamation> getReclamationByCode(String codepostal);
	
	public String updateReclamation3(Reclamation reclamation);
	
	public Reclamation updateReclamation4(long id, Reclamation rec);

}
