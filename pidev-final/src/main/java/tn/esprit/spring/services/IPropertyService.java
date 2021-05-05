package tn.esprit.spring.services;


import java.util.List;

import tn.esprit.spring.entities.Property;




public interface IPropertyService
{
	public String AjouterProperty (Property  property);
	public void deletePropertyById(int Id_Property); 
	public List<Property> getAllContrats();
	public void mettreAjourEmailByEmployeId( float price ,  int Id_Property) ; 
	public void affecterWarrantyAproperty(int Id_Property, int id_warranty); 
	public void affecterBuyAproperty(int Id_Property, int id_buy); 
	public void incrementeVue( int Id_Property); 
	public Property affichePropertyById(  int Id_Property) ; 
	public List<Property> triNbVue(); 
	public float  ApproximationProperty(float surface ,  String typeProperty  ); 

	
	

	

}
