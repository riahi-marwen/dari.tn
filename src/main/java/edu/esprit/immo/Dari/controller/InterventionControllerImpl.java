package edu.esprit.immo.Dari.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.esprit.immo.Dari.entities.Statut;
import edu.esprit.immo.Dari.entities.Intervention;
import edu.esprit.immo.Dari.entities.Reclamation;
import edu.esprit.immo.Dari.entities.Service;
import edu.esprit.immo.Dari.service.InterventionService;

//@Scope(value = "session")
@Controller(value = "interventionController")
@ELBeanName(value = "interventionController")
@Join(path = "/", to = "/intervention.jsf")
public class InterventionControllerImpl {
	 @Autowired
	 InterventionService interventionService; 
	 public List<Intervention> interventions; 
	 public List<Intervention> getInterventions(){ return interventionService.retieveAllIntervention(); }
	 
	 
	 public Long id_inter; 
	 public String titre;
	 public Statut statut ;
	 public Service service;
	 public Reclamation reclamations ;
	


	
	
	public InterventionService getInterventionService() {
		return interventionService;
	}


	public void setInterventionService(InterventionService interventionService) {
		this.interventionService = interventionService;
	}


	public Long getId_inter() {
		return id_inter;
	}


	public void setId_inter(Long id_inter) {
		this.id_inter = id_inter;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public Statut getStatut() {
		return statut;
	}


	public void setStatut(Statut statut) {
		this.statut = statut;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}


	public Reclamation getReclamations() {
		return reclamations;
	}


	public void setReclamations(Reclamation reclamations) {
		this.reclamations = reclamations;
	}

	

	public InterventionControllerImpl(InterventionService interventionService, List<Intervention> interventions,
			Long id_inter, String titre, Statut statut, Service service, Reclamation reclamations) {
		super();
		this.interventionService = interventionService;
		this.interventions = interventions;
		this.id_inter = id_inter;
		this.titre = titre;
		this.statut = statut;
		this.service = service;
		this.reclamations = reclamations;
	}

	

	public InterventionControllerImpl(Long id_inter, String titre, Statut statut, Service service,
			Reclamation reclamations) {
		super();
		this.id_inter = id_inter;
		this.titre = titre;
		this.statut = statut;
		this.service = service;
		this.reclamations = reclamations;
	}


	public InterventionControllerImpl(List<Intervention> interventions, Long id_inter, String titre, Statut statut,
			Service service, Reclamation reclamations) {
		super();
		this.interventions = interventions;
		this.id_inter = id_inter;
		this.titre = titre;
		this.statut = statut;
		this.service = service;
		this.reclamations = reclamations;
	}


	public InterventionControllerImpl(Long id_inter, String titre, Statut statut, Service service) {
		super();
		this.id_inter = id_inter;
		this.titre = titre;
		this.statut = statut;
		this.service = service;
		//this.reclamations = reclamations;
	}

	

	public InterventionControllerImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/*CRUD -----------*/


	public void addIntervention() {
		 interventionService.addIntervention(new Intervention(id_inter, titre, statut, service, reclamations));
	}

	
	 
	public void updateIntervention()
	{
		 interventionService.addIntervention(new Intervention(id_inter, titre, statut, service, reclamations));
	}

	public void RemoveIntervention(String id)
	{
		interventionService.deleteIntervention(id); 
	}
	
	public void DisplayIntervention(Intervention intervention)
	{
		this.setTitre(intervention.getTitre());
		this.setStatut(intervention.getStatut());
		this.setService(intervention.getService());
		this.setReclamations(intervention.getReclamations());
	}
	

	public Statut[] getStatuts() { return Statut.values(); }
	public Service[] getServices() { return Service.values(); }
	
	public String getRecalamations() { return reclamations.getNom(); }

}
