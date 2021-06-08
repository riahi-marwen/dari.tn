package edu.esprit.immo.Dari.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reclamations")
public class Reclamation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id; 
	
	 @Column(name = "civilite")
	 private String civilite;
	 @Column(name = "nom")
	 private String nom; 
	 @Column(name = "prenom")
	 private String prenom;
	 @Column(name = "email")
	 private String email;
	 @Column(name = "tele")
	 private String tele;
	 @Column(name = "address")
	 private String address;
	 @Column(name = "codepostal")
	 private String codepostal;
	 @Column(name = "ville")
	 private String ville;
	 @Column(name = "description")
	 private String description;
	 @Column(name = "comments")
	 private String comments;
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy="reclamations")
	 private Set<Intervention> interventions;
	 
	public Set<Intervention> getInterventions() {
		return interventions;
	}
	public void setInterventions(Set<Intervention> interventions) {
		this.interventions = interventions;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Reclamation(Long id, String civilite, String nom, String prenom, String email, String tele, String address,
			String codepostal, String ville, String description, String comments) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
		this.address = address;
		this.codepostal = codepostal;
		this.ville = ville;
		this.description = description;
		this.comments = comments;
	}
	
	
	
	public Reclamation(Long id, String civilite, String nom, String prenom, String email, String tele, String address,
			String codepostal, String ville, String description, String comments, Set<Intervention> interventions) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
		this.address = address;
		this.codepostal = codepostal;
		this.ville = ville;
		this.description = description;
		this.comments = comments;
		this.interventions = interventions;
	}
	
	
	public Reclamation(String civilite, String nom, String prenom) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Reclamation() {
		super();
	}
	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", tele=" + tele + ", address=" + address + ", codepostal=" + codepostal + ", ville=" + ville
				+ ", description=" + description + ", comments=" + comments + ", interventions=" + interventions + "]";
	}

	
	

	
	
	 
	 

}
