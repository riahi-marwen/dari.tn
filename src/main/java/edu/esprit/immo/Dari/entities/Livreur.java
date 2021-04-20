package edu.esprit.immo.Dari.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Livreur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idLivreur ;
	
	@Column(name = "nom_livreur")
	public String nomLivreur ;
	
	@Column (name= "email_livreur")
	public String emailLivreur; 
	
	@Column 
	public boolean disponnible ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "livreurs")
	public Set<Livraison> livraisons ;

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

	public Set<Livraison> getLivraisons() {
		return livraisons;
	}

	public void setLivraisons(Set<Livraison> livraisons) {
		this.livraisons = livraisons;
	}

	public Livreur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livreur(int idLivreur, String nomLivreur, String emailLivreur, boolean disponnible,
			Set<Livraison> livraisons) {
		super();
		this.idLivreur = idLivreur;
		this.nomLivreur = nomLivreur;
		this.emailLivreur = emailLivreur;
		this.disponnible = disponnible;
		this.livraisons = livraisons;
	}
	
	
	
	
	
	

}
