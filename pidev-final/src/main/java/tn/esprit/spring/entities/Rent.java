package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Rent implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  Id_Rent; 
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date date_start;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date date_end; 
	private float price ; 
	private String name_renter ; 
	private String name_owner ; 
	@Enumerated(EnumType.STRING)
	private TypeRent type_rent ; 
	
	public int getId_Rent() {
		return Id_Rent;
	}
	public void setId_Rent(int id_Rent) {
		Id_Rent = id_Rent;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getName_renter() {
		return name_renter;
	}
	public void setName_renter(String name_renter) {
		this.name_renter = name_renter;
	}
	public String getName_owner() {
		return name_owner;
	}
	public void setName_owner(String name_owner) {
		this.name_owner = name_owner;
	}
		
	public Date getDate_start() {
		return date_start;
	}
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}
	

	
	public Date getDate_end() {
		return date_end;
	}
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}
	public Rent(int id_Rent, Date date_start, Date date_end, float price, String name_renter, String name_owner,
			TypeRent type_rent, Property property) {
		super();
		Id_Rent = id_Rent;
		this.date_start = date_start;
		this.date_end = date_end;
		this.price = price;
		this.name_renter = name_renter;
		this.name_owner = name_owner;
		this.type_rent = type_rent;
		this.property = property;
	}
	public Rent(int id_Rent, Date date_start, Date date_end, float price, String name_renter, String name_owner,
			TypeRent type_rent) {
		super();
		Id_Rent = id_Rent;
		this.date_start = date_start;
		this.date_end = date_end;
		this.price = price;
		this.name_renter = name_renter;
		this.name_owner = name_owner;
		this.type_rent = type_rent;
		
	}
	public Rent( Date date_start, Date date_end, float price, String name_renter, String name_owner,
			TypeRent type_rent) {
		super();
	
		this.date_start = date_start;
		this.date_end = date_end;
		this.price = price;
		this.name_renter = name_renter;
		this.name_owner = name_owner;
		this.type_rent = type_rent;
		
	}
	public Rent( Date date_start, Date date_end, float price, String name_renter, String name_owner,
			TypeRent type_rent, Property property) {
		super();
		this.date_start = date_start;
		this.date_end = date_end;
		this.price = price;
		this.name_renter = name_renter;
		this.name_owner = name_owner;
		this.type_rent = type_rent;
		this.property = property;
	}
	public TypeRent getType_rent() {
		return type_rent;
	}
	public void setType_rent(TypeRent type_rent) {
		this.type_rent = type_rent;
	}


	public Rent() 
	{
		super();
	}


	@ManyToOne
	private Property property ;

	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	} 
	
	
	

}
