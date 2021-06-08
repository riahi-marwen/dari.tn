package edu.esprit.immo.Dari.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.esprit.immo.Dari.entities.Etat;
import edu.esprit.immo.Dari.entities.Livraison;
import edu.esprit.immo.Dari.entities.Livreur;
import edu.esprit.immo.Dari.entities.Secteur;
import edu.esprit.immo.Dari.service.LivraisonService;

@ManagedBean
@Scope(value = "session")
@Component(value = "livraisonCo")
@ELBeanName(value = "livraisonCo")
@Join(path = "/", to = "/welcome.jsf")
public class LivraisonControllerImpl {
	

	@Autowired 
	LivraisonService livraisonService ;
	public List<Livraison> livraison ; 
	
	 public List<Livraison> getLivraisons(){
		 return livraisonService.retrieveAllLivraison(); }
	 
	 
	 public int idLivraison; 
	
	 public Date dateLivraison;
	 public Etat etat ; 
	 public Secteur adresse ;
	 public Livreur livreurs;
	 public List<Livraison> livraisons; 
	 public Livraison selectedLivraisons ;
 
	public List<Livraison> getLivraison() {
		return livraison;
	}
	public void setLivraison(List<Livraison> livraison) {
		this.livraison = livraison;
	}
	public int getIdLivraison() {
		return idLivraison;
	}
	public void setIdLivraison(int idLivraison) {
		this.idLivraison = idLivraison;
	}
	public Date getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Secteur getAdresse() {
		return adresse;
	}
	public void setAdresse(Secteur adresse) {
		this.adresse = adresse;
	}
	
	public Livreur getLivreurs() {
		return livreurs;
	}
	public void setLivreurs(Livreur livreurs) {
		this.livreurs = livreurs;
	}
	public LivraisonControllerImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LivraisonControllerImpl(Date dateLivraison, Etat etat, Secteur adresse) {
		super();
		this.dateLivraison = dateLivraison;
		this.etat = etat;
		this.adresse = adresse;
	}
	
	/*--------------CRUD -----------*/

	
	 
	public void addLivraison () {
	Livraison liv =new Livraison(idLivraison,dateLivraison,etat,null, adresse, livreurs);
		if (livraisonService.affectationAutoLivreur(liv.getAdresse())!= null)
		{
			liv.setLivreurs(livraisonService.affectationAutoLivreur(liv.getAdresse()));
			
		}

		
		livraisonService.addLivraison(liv);
	}
	
	public void updateLivraison() {
		
		livraisonService.addLivraison(new Livraison(idLivraison,dateLivraison,etat,null, adresse, livreurs));

	}
	
	public void RemoveLivraison (int id )
	{
		livraisonService.deleteLivraison(id);
	}
	
	public void DisplayLivraison(Livraison livraison)
	{
		this.setIdLivraison(livraison.getIdLivraison());
		this.setDateLivraison(livraison.getDateLivraison());
		this.setEtat(livraison.getEtat());
		this.setAdresse(livraison.getAdresse());
		
	}
	public Livraison getSelectedLivraisons() {
		return selectedLivraisons;
	}
	public void setSelectedLivraisons(Livraison selectedLivraisons) {
		this.selectedLivraisons = selectedLivraisons;
	}
	public void setLivraisons(List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}
	
	
	public Secteur[] getAdresses() { return Secteur.values(); }
	public Etat[] getEtats() { return Etat.values();}
	public LivraisonControllerImpl(int idLivraison, Date dateLivraison, Etat etat, Secteur adresse, Livreur livreurs) {
		super();
		this.idLivraison = idLivraison;
		this.dateLivraison = dateLivraison;
		this.etat = etat;
		this.adresse = adresse;
		this.livreurs = livreurs;
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
