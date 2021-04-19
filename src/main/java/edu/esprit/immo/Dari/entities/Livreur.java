package edu.esprit.immo.Dari.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	
	
	

}
