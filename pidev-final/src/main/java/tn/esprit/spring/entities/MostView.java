package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class MostView implements Serializable
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id_MostView; 
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date miseAjour;
	
	@OneToOne
	private Property property;
	
	
	
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	
	public int getId_MostView() {
		return id_MostView;
	}
	public void setId_MostView(int id_MostView) {
		this.id_MostView = id_MostView;
	}
	public Date getMiseAjour() {
		return miseAjour;
	}
	public void setMiseAjour(Date miseAjour) {
		this.miseAjour = miseAjour;
	}
	public MostView(Date miseAjour) {
		super();
		this.miseAjour = miseAjour;
	}
	public MostView() {
		super();
		
	}
	
	
	
}
