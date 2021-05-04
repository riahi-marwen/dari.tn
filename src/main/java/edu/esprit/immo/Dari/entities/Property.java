package edu.esprit.immo.Dari.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Property implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProperty ;
	
	@Column (name = "NameProp")
	public String nameProperty  ; 
	
	@Column 
	public String typeProperty ;
	
	@Column (name = "image")
	public String imageProperty ; 
	
	@Column (name = "surfaceProp")
	public float surfaceProperty ;
	
	@Column (name = "priceProper")
	public int priceProperty  ;
	
	@Column (name = "AdreesProper")
	public String  adressProperty ; 
	
	@Column (name = "CityProper")
	public String cityProperty ; 
	
	@Column (name = "DescriptionProper")
	public String  descriptionProperty;
	
	@OneToOne
	private Appointment appointment ;
	
	@ManyToOne 
	User users ;

	public int getIdProperty() {
		return idProperty;
	}

	public void setIdProperty(int idProperty) {
		this.idProperty = idProperty;
	}

	public String getNameProperty() {
		return nameProperty;
	}

	public void setNameProperty(String nameProperty) {
		this.nameProperty = nameProperty;
	}

	public String getTypeProperty() {
		return typeProperty;
	}

	public void setTypeProperty(String typeProperty) {
		this.typeProperty = typeProperty;
	}

	public String getImageProperty() {
		return imageProperty;
	}

	public void setImageProperty(String imageProperty) {
		this.imageProperty = imageProperty;
	}

	public float getSurfaceProperty() {
		return surfaceProperty;
	}

	public void setSurfaceProperty(float surfaceProperty) {
		this.surfaceProperty = surfaceProperty;
	}

	public int getPriceProperty() {
		return priceProperty;
	}

	public void setPriceProperty(int priceProperty) {
		this.priceProperty = priceProperty;
	}

	public String getAdressProperty() {
		return adressProperty;
	}

	public void setAdressProperty(String adressProperty) {
		this.adressProperty = adressProperty;
	}

	public String getCityProperty() {
		return cityProperty;
	}

	public void setCityProperty(String cityProperty) {
		this.cityProperty = cityProperty;
	}

	public String getDescriptionProperty() {
		return descriptionProperty;
	}

	public void setDescriptionProperty(String descriptionProperty) {
		this.descriptionProperty = descriptionProperty;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property(int idProperty, String nameProperty, String typeProperty, String imageProperty,
			float surfaceProperty, int priceProperty, String adressProperty, String cityProperty,
			String descriptionProperty, Appointment appointment, User users) {
		super();
		this.idProperty = idProperty;
		this.nameProperty = nameProperty;
		this.typeProperty = typeProperty;
		this.imageProperty = imageProperty;
		this.surfaceProperty = surfaceProperty;
		this.priceProperty = priceProperty;
		this.adressProperty = adressProperty;
		this.cityProperty = cityProperty;
		this.descriptionProperty = descriptionProperty;
		this.appointment = appointment;
		this.users = users;
	}
	
	
	
	
	

}
