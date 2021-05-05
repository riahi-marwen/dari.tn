package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Favourite implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id_fav; 
	private String date_fav;

	@ManyToMany(mappedBy="favourites")
	private List<Property> propertys; 
	
	
	public List<Property> getPropertys() {
		return propertys;
	}
	public void setPropertys(List<Property> propertys) {
		this.propertys = propertys;
	}
	public int getId_fav() {
		return id_fav;
	}
	public void setId_fav(int id_fav) {
		this.id_fav = id_fav;
	}
	public String getDate_fav() {
		return date_fav;
	}
	public void setDate_fav(String date_fav) {
		this.date_fav = date_fav;
	}
	public Favourite(String date_fav) {
		super();
		this.date_fav = date_fav;
	}
	
	
}
