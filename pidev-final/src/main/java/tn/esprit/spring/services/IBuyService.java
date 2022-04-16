package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Buy;



public interface IBuyService 
{

	public String AjouterBuy (Buy  buy);
	public void mettreAjourPriceBuy(float  price ,   int id_buy); 
	public void deletePropertyById(int id_warranty); 
	public List<Buy> getAllContrats() ; 
		

}
