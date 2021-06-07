package edu.esprit.immo.Dari.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import edu.esprit.immo.Dari.entities.Livreur;
import edu.esprit.immo.Dari.entities.Secteur;
import edu.esprit.immo.Dari.service.LivreurService;
@ManagedBean
@Scope(value = "session")
@Component(value = "livreurCo")
@ELBeanName(value = "livreurCo")
@Join(path = "/", to = "/welcome.jsf")

public class LivreurComtrollerImpl {
	
	 @Autowired
	 LivreurService livreurService; 
	 public List<Livreur> livreur; 
	 public List<Livreur> getLivreurs(){
		 return livreurService.retieveAllLivreur(); }
	
	
	public int idLivreur ; 
	public String nomLivreur ; 
	public String emailLivreur; 
	public boolean disponnible ;
	public Secteur secteur;
	public List<Livreur> livreurs ;  
	public Livreur selectedLivreurs ; 
	
	public Secteur[] getSecteurs() { return Secteur.values(); }
	 public LivreurService getLivreurService() {
		return livreurService;
	}

	public List<Livreur> getLivreur() {
		return livreur;
	}

	public void setLivreur(List<Livreur> livreur) {
		this.livreur = livreur;
	}

	public int getIdLivreur() {
		return idLivreur;
	}

	public void setIdLivreur(int idLivreur) {
		this.idLivreur = idLivreur;
	}

	public String getNomLivreur() {
		return nomLivreur;
	}

	public void setNomLivreur(String nomLivreur) {
		this.nomLivreur = nomLivreur;
	}

	public String getEmailLivreur() {
		return emailLivreur;
	}

	public void setEmailLivreur(String emailLivreur) {
		this.emailLivreur = emailLivreur;
	}

	public boolean isDisponnible() {
		return disponnible;
	}

	public void setDisponnible(boolean disponnible) {
		this.disponnible = disponnible;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public Livreur getSelectedLivreurs() {
		return selectedLivreurs;
	}

	public void setSelectedLivreurs(Livreur selectedLivreurs) {
		this.selectedLivreurs = selectedLivreurs;
	}

	public void setLivreurService(LivreurService livreurService) {
		this.livreurService = livreurService;
	}

	public void setLivreurs(List<Livreur> livreurs) {
		this.livreurs = livreurs;
	}

	public LivreurComtrollerImpl(LivreurService livreurService, List<Livreur> livreur, int idLivreur, String nomLivreur,
			String emailLivreur, boolean disponnible, Secteur secteur, List<Livreur> livreurs,
			Livreur selectedLivreurs) {
		super();
		this.livreurService = livreurService;
		this.livreur = livreur;
		this.idLivreur = idLivreur;
		this.nomLivreur = nomLivreur;
		this.emailLivreur = emailLivreur;
		this.disponnible = disponnible;
		this.secteur = secteur;
		this.livreurs = livreurs;
		this.selectedLivreurs = selectedLivreurs;
	}
	

	public LivreurComtrollerImpl(int idLivreur, String nomLivreur, String emailLivreur, boolean disponnible,
			Secteur secteur) {
		super();
		this.idLivreur = idLivreur;
		this.nomLivreur = nomLivreur;
		this.emailLivreur = emailLivreur;
		this.disponnible = disponnible;
		this.secteur = secteur;
	}

	public LivreurComtrollerImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LivreurComtrollerImpl [livreurService=" + livreurService + ", livreur=" + livreur + ", idLivreur="
				+ idLivreur + ", nomLivreur=" + nomLivreur + ", emailLivreur=" + emailLivreur + ", disponnible="
				+ disponnible + ", secteur=" + secteur + ", livreurs=" + livreurs + ", selectedLivreurs="
				+ selectedLivreurs + "]";
	}

	/*--------------CRUD -----------*/
	
	public void addLivreur() {
		livreurService.addLivreur(new Livreur(idLivreur,nomLivreur,emailLivreur,disponnible,secteur, null));
	}
	 
	public void updateLivreur()
	{
		livreurService.addLivreur(new Livreur(idLivreur,nomLivreur,emailLivreur,disponnible,secteur, null));
	}
	
	public void RemoveLivreur(int id )
	{
		livreurService.deleteLivreur(id); 
	}
	

	public void DisplayLivreur(Livreur livreur)
	{
		this.setIdLivreur(livreur.getIdLivreur());
		this.setNomLivreur(livreur.getNomLivreur());
		this.setEmailLivreur(livreur.getEmailLivreur());
		this.setDisponnible(livreur.isDisponnible());
		this.setSecteur(livreur.getSecteur());
	}
	
	
	public String  navigToAjouterLivr()
	{
		String navigateTo = "null";
		navigateTo = "/pages/admin/ajoutLivreur.xhtml";
		return navigateTo;	
		
	}

	
   	
	 }
	 
	 
	 
	 
