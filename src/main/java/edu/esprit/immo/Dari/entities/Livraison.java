package edu.esprit.immo.Dari.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private Date dateLivraison;
	
	@Enumerated(EnumType.STRING)
	Etat etat ; 

}
