package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Buy implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id_buy; 
	private String date;
	private String Name_buyer; 
	private float price ;
	public int getId_buy() {
		return id_buy;
	}
	public void setId_buy(int id_buy) {
		this.id_buy = id_buy;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName_buyer() {
		return Name_buyer;
	}
	public void setName_buyer(String name_buyer) {
		Name_buyer = name_buyer;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public Buy(int id_buy, String date, String name_buyer, float price) {
		super();
		this.id_buy = id_buy;
		this.date = date;
		Name_buyer = name_buyer;
		this.price = price;
	}
	public Buy(String date, String name_buyer, float price) {
		super();
		this.date = date;
		Name_buyer = name_buyer;
		this.price = price;
	}
	@OneToOne
	private Property property;
	
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	
	
	

}
