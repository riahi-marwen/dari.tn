package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Warranty implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_warranty ; 
	private String title ;
	public int getId_warranty() {
		return id_warranty;
	}
	public void setId_warranty(int id_warranty) {
		this.id_warranty = id_warranty;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Warranty(String title) {
		super();
		this.title = title;
	} 
	
	public Property getProperty() {
		return property;
	}
	public Warranty(String title, Property property) {
		super();
		this.title = title;
		this.property = property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}

	@OneToOne
	private Property property ; 
	
	
}
