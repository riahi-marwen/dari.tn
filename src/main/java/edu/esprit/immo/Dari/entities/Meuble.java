package edu.esprit.immo.Dari.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meuble implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idMeuble ;

	@Column
	public String description ;
	
	@Column
	public float prixMeuble ;

	public int getIdMeuble() {
		return idMeuble;
	}

	public void setIdMeuble(int idMeuble) {
		this.idMeuble = idMeuble;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrixMeuble() {
		return prixMeuble;
	}

	public void setPrixMeuble(float prixMeuble) {
		this.prixMeuble = prixMeuble;
	}

	public Meuble() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meuble(int idMeuble, String description, float prixMeuble) {
		super();
		this.idMeuble = idMeuble;
		this.description = description;
		this.prixMeuble = prixMeuble;
	}
	
	
	
}
