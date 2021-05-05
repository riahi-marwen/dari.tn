package tn.esprit.spring.services;


import java.util.List;

import tn.esprit.spring.entities.Favourite;


public interface IFavouriteService 
{

	public String AjouterFavourite  (Favourite favourite);
	public void deletePropertyById(int id_fav) ; 
	public List<Favourite> getAllContrats() ; 
	public void mettreAjourPriceBuy(String   date_fav  ,   int id_fav) ; 
	public void deleteFavourite(); 




}
