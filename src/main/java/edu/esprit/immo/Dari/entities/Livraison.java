package edu.esprit.immo.Dari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livraison implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public int idLivraison; 
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_livraison")
	public Date dateLivraison;
	
	@Enumerated(EnumType.STRING)
	Etat etat ; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "livraisons")
	@JsonIgnore
	public Set<Commande> commandes ;
	
	@Enumerated(EnumType.STRING)
	Secteur adresse ;
	
	@ManyToOne
	
	Livreur livreurs ;

	public Livreur getLivreurs() {
		return livreurs;
	}

	public void setLivreurs(Livreur livreurs) {
		this.livreurs = livreurs;
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

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	

	

	public Secteur getAdresse() {
		return adresse;
	}

	public void setAdresse(Secteur adresse) {
		this.adresse = adresse;
	}

	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livraison(int idLivraison, Date dateLivraison, Etat etat, Set<Commande> commandes, Secteur adresse,
			Livreur livreurs) {
		super();
		this.idLivraison = idLivraison;
		this.dateLivraison = dateLivraison;
		this.etat = etat;
		this.commandes = commandes;
		this.adresse = adresse;
		this.livreurs = livreurs;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	

	

	
	
	
	
	
	
	
	

}
