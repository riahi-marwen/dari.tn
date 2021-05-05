package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Buy;
import tn.esprit.spring.entities.Property;
import tn.esprit.spring.entities.Rent;
import tn.esprit.spring.entities.Warranty;
import tn.esprit.spring.repository.IBuyRepositry;
import tn.esprit.spring.repository.IPropertyRepository;
import tn.esprit.spring.repository.IRentRepositry;
import tn.esprit.spring.repository.IWarrantyRepositry;


@Service
public class IPropertyServiceImpl implements IPropertyService{
	@Autowired
	IPropertyRepository proprep;
	@Autowired
	IWarrantyRepositry iwarrantty ; 
	@Autowired
	IBuyRepositry ibuy ; 
	@Autowired
	IRentRepositry irent; 
	
	@Override
	/* ajout de property */
	public String AjouterProperty(Property property) {
	proprep.save(property);
	return "the property is aded successfyly";
		
	}
	/* tri nb de vue de propety*/
	public List<Property> triNbVue() {
		return (proprep.getTriNbvueProperty()); 
	}
	@Override
	/* affiche  property by id */
	public Property affichePropertyById(int Id_Property) {
		
		Property property = proprep.findById(Id_Property).get();
        return property ;
	}
	/* supprimer property*/

	public void deletePropertyById(int Id_Property) {
		proprep.delete(proprep.findById(Id_Property).get());	
		}
	
	/* retourner liste de property*/
	public List<Property> getAllContrats() {
		return (List<Property>) proprep.findAll();
	}
	/* incrémente le nb de vue */
	public void incrementeVue(int Id_Property) 
	{
		Property property = proprep.findById(Id_Property).get();
		property.setNbVue(property.getNbVue()+1 );
		proprep.save(property);
	}
	/* modifier property name_Property et price */
	public void mettreAjourEmailByEmployeId(float price ,  int Id_Property) 
	{
		Property property = proprep.findById(Id_Property).get();
		property.setPrice(price);
		proprep.save(property);
	}
	/* affecter Warranty to property */
	public void affecterWarrantyAproperty(int Id_Property, int id_warranty) 
	{
		Property propertyManagedEntity = proprep.findById(Id_Property).get();
		Warranty warrantyManagedEntity = iwarrantty.findById(id_warranty).get();
		propertyManagedEntity.setWarranty(warrantyManagedEntity);
		proprep.save(propertyManagedEntity); 
	}
	/* affecter Buy  to property */
	public void affecterBuyAproperty(int Id_Property, int id_buy) 
	{
		Property propertyManagedEntity = proprep.findById(Id_Property).get();
		Buy buyManagedEntity = ibuy.findById(id_buy).get();
		propertyManagedEntity.setBuy(buyManagedEntity);
		proprep.save(propertyManagedEntity); 
	}
	
	/* affecter Rent   to property */
	public void affecterRentAProperty(int Id_Property, int Id_Rent) {
		Property propertyManagedEntity = proprep.findById(Id_Property).get();
		Rent rent = irent.findById(Id_Rent).get();
		rent.setProperty(propertyManagedEntity);
		irent.save(rent);
		
	}
	/* desaffecter Rent to property */
	public void desaffecterRentProperty(int Id_Rent, int Id_Property)
	{
		Property propertyManagedEntity = proprep.findById(Id_Property).get();
		int rentNB = propertyManagedEntity.getRents().size(); 
		for(int index = 0; index < rentNB; index++)
		{
			if(propertyManagedEntity.getRents().get(index).getId_Rent() == Id_Rent){
				propertyManagedEntity.getRents().remove(index);
				break;
			}
		}
	}

	/* approximation prix*/
	
	public float  ApproximationProperty(float surface ,  String typeProperty  )
	{
		float prix=0 ; 
		if (typeProperty =="Appartement")
		{
			prix =prix + 200 ; 
		}
		else
		{
			if(typeProperty =="villa")
			{
				prix=prix + 400 ; 
				
			}
			else
			{
				if(typeProperty =="house")
				{
					prix = prix + 600 ; 
				}
				
				
			}
		}
		if (surface<=100)
		{
			prix = prix + 200 ; 
		}
		else
		{ 
			if((surface >=100)&&(surface<=150) )
			{
				prix = prix +300 ; 
			}
			else
			{
				prix = prix + (surface * 4) ; 
			}
			
		}
		
		
		return prix ; 
		
	}
	
	
	
	
	
	
	
	
	
	

	

}
