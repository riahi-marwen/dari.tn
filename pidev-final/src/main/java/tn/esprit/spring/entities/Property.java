package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.transaction.annotation.EnableTransactionManagement;



@Entity
public class Property implements Serializable
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id_Property; 
	public List<Favourite> getFavourites() {
		return favourites;
	}
	public void setFavourites(List<Favourite> favourites) {
		this.favourites = favourites;
	}

	private String name_Property;
	private String Type_Property ; 
	private float price ; 
	private String adresse ; 
	private String city ; 
	@Enumerated(EnumType.STRING)
	private TypeProperty type ;
	private  String  description ;
	private int nbVue ; 
	private int surface ; 
	private int nbPiece ; 
	
	
	
	
	public int getSurface() {
		return surface;
	}
	public void setSurface(int surface) {
		this.surface = surface;
	}
	public int getNbPiece() {
		return nbPiece;
	}
	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}
	public Property(String name_Property,TypeProperty type,  float price, String adresse, String city,String description, int surface ,int nbPiece ) {
		super();
		this.name_Property = name_Property;
		this.type=type; 
		this.price = price;
		this.adresse = adresse;
		this.city = city;
		this.description = description;
		this.surface=surface; 
		this.nbPiece = nbPiece ; 
		
	}	
	public Property(int id_Property  , String name_Property,TypeProperty type,  float price, String adresse, String city,String description, int surface ,int nbPiece ) {
		super();
		this.id_Property=id_Property; 
		this.name_Property = name_Property;
		this.type=type; 
		this.price = price;
		this.adresse = adresse;
		this.city = city;
		this.description = description;
		this.surface=surface; 
		this.nbPiece = nbPiece ; 
		
	}
	public int getNbVue() {
		return nbVue;
	}
	public void setNbVue(int nbVue) {
		this.nbVue = nbVue;
	}
	
	
	
	public int getId_Property() {
		return id_Property;
	}
	public void setId_Property(int id_Property) {
		this.id_Property = id_Property;
	}
	public String getName_Property() {
		return name_Property;
	}
	public void setName_Property(String name_Property) {
		this.name_Property = name_Property;
	}
	public String getType_Property() {
		return Type_Property;
	}
	public void setType_Property(String type_Property) {
		Type_Property = type_Property;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Property(String name_Property, String type_Property, float price, String adresse, String city,
			String description) {
		super();
		this.name_Property = name_Property;
		Type_Property = type_Property;
		this.price = price;
		this.adresse = adresse;
		this.city = city;
		this.description = description;
	}
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
	public MostView getMostView() {
		return mostView;
	}
	public void setMostView(MostView mostView) {
		this.mostView = mostView;
	}

	@OneToOne(mappedBy="property")
	private Buy buy; 
	
	@OneToOne(mappedBy="property")
	private MostView mostView ;  

	
	@OneToOne(mappedBy="property")
	private Warranty warranty;
	
	@OneToMany(mappedBy="property")
	private List<Rent> rents ; 
	
	@ManyToMany
	private List<Favourite> favourites; 

	
	public List<Rent> getRents() {
		return rents;
	}
	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
	public Property(String name_Property, String type_Property, float price, String adresse, String city,
			String description, Buy buy, Warranty warranty) 
	{
		super();
		this.name_Property = name_Property;
		this.Type_Property = type_Property;
		this.price = price;
		this.adresse = adresse;
		this.city = city;
		this.description = description;
		this.buy = buy;
		this.warranty = warranty;
	}
	public Buy getBuy() {
		return buy;
	}
	public void setBuy(Buy buy) {
		this.buy = buy;
	}
	public Warranty getWarranty() {
		return warranty;
	}
	public void setWarranty(Warranty warranty) {
		this.warranty = warranty;
	}
	public TypeProperty getType() {
		return type;
	}
	public void setType(TypeProperty type) {
		this.type = type;
	}
	public Property(int id_Property, String name_Property, String type_Property, float price, String adresse,
			String city, TypeProperty type, String description, Buy buy, Warranty warranty, List<Rent> rents) {
		super();
		id_Property = id_Property;
		this.name_Property = name_Property;
		Type_Property = type_Property;
		this.price = price;
		this.adresse = adresse;
		this.city = city;
		this.type = type;
		this.description = description;
		this.buy = buy;
		this.warranty = warranty;
		this.rents = rents;
	}
	
	
	
	
	
	
	
}
