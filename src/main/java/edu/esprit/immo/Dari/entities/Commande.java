package edu.esprit.immo.Dari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int ref ; 
	
	@Column
	private float prixCmd ;
	
	@Column
	public  boolean reglement ;
	
	@Column
	private int quantiteCmd ;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_cmd")
	private Date dateCmd;
	
	@OneToMany(cascade = CascadeType.ALL)
	public Set<Meuble> meubles ;

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public float getPrixCmd() {
		return prixCmd;
	}

	public void setPrixCmd(float prixCmd) {
		this.prixCmd = prixCmd;
	}

	public boolean isReglement() {
		return reglement;
	}

	public void setReglement(boolean reglement) {
		this.reglement = reglement;
	}

	public int getQuantiteCmd() {
		return quantiteCmd;
	}

	public void setQuantiteCmd(int quantiteCmd) {
		this.quantiteCmd = quantiteCmd;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public Set<Meuble> getMeubles() {
		return meubles;
	}

	public void setMeubles(Set<Meuble> meubles) {
		this.meubles = meubles;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(int ref, float prixCmd, boolean reglement, int quantiteCmd, Date dateCmd, Set<Meuble> meubles) {
		super();
		this.ref = ref;
		this.prixCmd = prixCmd;
		this.reglement = reglement;
		this.quantiteCmd = quantiteCmd;
		this.dateCmd = dateCmd;
		this.meubles = meubles;
	} 
	
	
	
	
	
	
	
	
	
	
	
	

}
