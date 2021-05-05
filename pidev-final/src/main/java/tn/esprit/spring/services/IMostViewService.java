package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.MostView;


public interface IMostViewService 
{
	public int AjouterMostView(MostView mostView); 
	public void deleteMostViewById(int id_MostView) ; 
	public void deleteMostView() ; 
	public List<MostView> getAllMostView(); 
	public List<MostView> remplirMostView(); 
	public void affecterMostViewAProperty(int Id_Property, int id_MostView); 



}
