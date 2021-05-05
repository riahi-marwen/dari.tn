package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Warranty;



public interface IWarrantyService
{
	public String AjouterWarranty (Warranty  warranty);
	public void deletePropertyById(int id_warranty); 
	public List<Warranty> getAllContrats(); 
	public void mettreAjourTitleByWarrantyId(String title ,   int id_warranty) ; 

}
