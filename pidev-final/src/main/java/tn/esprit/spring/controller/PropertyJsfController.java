package tn.esprit.spring.controller;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Property;
import tn.esprit.spring.entities.TypeProperty;
import tn.esprit.spring.services.IPropertyService;

@Scope(value = "session")
@Controller(value = "propertyControlle")
@ELBeanName(value = "propertyControlle")
@Join(path = "/welcome.jsf", to = "/property.jsf")
public class PropertyJsfController 
{
	private String name_Property; 
	private float price ; 
	private String adresse ; 
	private String city ; 
	private TypeProperty type ;
	private  String  description ;
	private int nbVue ; 
	private int surface ; 
	private int nbPiece ; 
	
	
	private int propertyIdToBeUpdated; 
	
	
	
	
	public int getPropertyIdToBeUpdated() {
		return propertyIdToBeUpdated;
	}

	public void setPropertyIdToBeUpdated(int propertyIdToBeUpdated) {
		this.propertyIdToBeUpdated = propertyIdToBeUpdated;
	}

	public TypeProperty[] getTypes()
	{
		return TypeProperty.values();
	}
	private List<Property> propertys; 

	@Autowired
	IPropertyService propertyService ; 
	
	public String addEmploye()
	{
		propertyService.AjouterProperty(new Property(name_Property, type, price, adresse, city, description,surface, nbPiece));
		return "null"; 
	}

	public List<Property> getPropertys() {
		return propertyService.getAllContrats(); 
	
	}

	
	public void removeProperty(int propertyId) 
	{
		
		propertyService.deletePropertyById(propertyId); 	 
	} 
	
	
	public void displayProperty (Property property)
	{
		this.setName_Property(property.getName_Property());
		this.setType(property.getType());
		this.setPrice(property.getPrice());
		this.setAdresse(property.getAdresse());
		this.setCity(property.getCity());
		this.setDescription(property.getDescription());
		this.setSurface(property.getSurface());
		this.setNbPiece(property.getNbPiece());
		this.setPropertyIdToBeUpdated(property.getId_Property());
		
	}
	public void updateProperty()
	{
		propertyService.AjouterProperty(new Property(propertyIdToBeUpdated, name_Property, type, price, adresse, city, description, surface, nbPiece));
	}
	
	
	
	
	
	
	
	public void setPropertys(List<Property> propertys) {
		this.propertys = propertys;
	}

	public String getName_Property() {
		return name_Property;
	}

	public void setName_Property(String name_Property) {
		this.name_Property = name_Property;
	}

	
	public IPropertyService getPropertyService() {
		return propertyService;
	}

	public void setPropertyService(IPropertyService propertyService) {
		this.propertyService = propertyService;
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

	public TypeProperty getType() {
		return type;
	}

	public void setType(TypeProperty type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbVue() {
		return nbVue;
	}

	public void setNbVue(int nbVue) {
		this.nbVue = nbVue;
	}

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
	
	
	
	
	
}
