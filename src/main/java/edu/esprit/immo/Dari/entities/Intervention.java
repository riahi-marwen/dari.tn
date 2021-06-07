package edu.esprit.immo.Dari.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "Interventions")
public class Intervention implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 public Long id_inter; 
	 
	 @Column(name = "titre")
	 public String titre;
	 @Enumerated(EnumType.STRING)
	 public Statut statut;
	 @Enumerated(EnumType.STRING)
	 public Service service;
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 Reclamation reclamations ;
	
	 
	 Long getId_inter() {
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

	public Reclamation getReclamations() {
		return reclamations;
	}

	public void setReclamations(Reclamation reclamations) {
		this.reclamations = reclamations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Intervention(Long id_inter, String titre, Statut statut, Service service, Reclamation reclamations) {
		super();
		this.id_inter = id_inter;
		this.titre = titre;
		this.statut = statut;
		this.service = service;
		this.reclamations = reclamations;
	}

	
	public Intervention(Long id_inter, String titre, Statut statut, Service service) {
		super();
		this.id_inter = id_inter;
		this.titre = titre;
		this.statut = statut;
		this.service = service;
	}

	public Intervention() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Intervention [id_inter=" + id_inter + ", titre=" + titre + ", statut=" + statut + ", service=" + service
				+ ", reclamations=" + reclamations + "]";
	}

	

	

	 
	 

	
	
	 

}
