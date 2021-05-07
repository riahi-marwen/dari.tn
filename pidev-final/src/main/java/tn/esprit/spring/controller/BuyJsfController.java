package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Buy;
import tn.esprit.spring.services.IBuyService;

@Scope(value = "session")
@Controller(value = "buyControlle")
@ELBeanName(value = "buyControlle")
@Join(path = "/property.jsf", to = "/buy.jsf")
public class BuyJsfController
{
	@Autowired
	IBuyService buyService ; 
	private String date;
	private String name_buyer; 
	private float price ;
	private int buyId; 
	
	private List<Buy> buys ;
	
	
	
	public List<Buy> getBuys() {
		return buyService.getAllContrats(); 
	}
	
	/* ajouut */
	
	public String ajouBuy()
	{
		buyService.AjouterBuy(new Buy(date, name_buyer, price)); 
		return "null"; 
	}
	/* remove */
	public void removeBuy(int buyId)
	{
		buyService.deletePropertyById(buyId);
	}
	/* modification */
	public void  updateBuy()
	{
		buyService.AjouterBuy(new Buy(buyId, date, name_buyer, price)); 
	}
	/* display*/

	
	
	

	public IBuyService getBuyService() {
		return buyService;
	}

	public void setBuyService(IBuyService buyService) {
		this.buyService = buyService;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getBuyId() {
		return buyId;
	}

	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}

	

	public void setBuys(List<Buy> buys) {
		this.buys = buys;
	} 
	
	
	
	
	
	
	
	
	

}
