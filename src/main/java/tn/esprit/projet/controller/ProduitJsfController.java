package tn.esprit.projet.controller;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.projet.modal.Produit;
import tn.esprit.projet.modal.UploadFile;
import tn.esprit.projet.service.ProduitService;

@Scope(value = "session")
@Controller(value = "produitControlle")
@ELBeanName(value = "produitControlle")
@Join(path = "/welcome.jsf", to = "/produit.jsf")
public class ProduitJsfController {
	@Autowired
	ProduitService produitService;
	
	private Double note;
    private Double priceProduit;
    private String nameProduit;
    private Date dateCreation;
    private  int quantity;
    private int  test  ; 
  // private UploadFile image ;
   /* public UploadFile getImage() {
		return image;
	}
	public void setImage(UploadFile image) {
		this.image = image;
	}*/
    private Long produitIdToBeUpdated;
    private List<Produit> pts;
    
	private List<Produit> propertys; 
   
    
   /* public String RechercheParNom (String nameProduit)
	 {
		 String navigateTo="null"; 
	     this.setPts(produitService.getProduitByName(nameProduit)); 
		 return  navigateTo="/pages/admin/recherche.xhtml" ; 
		 
		 
	 }*/
    
   
   
   /* public String triNote()
	{
		this.setPts(produitService.triNote());
		String navigateTo = "null";
		navigateTo = "/pages/admin/filter.xhtml";
		return navigateTo;			
	}*/
   
	

	
    public String addProduit()
	{
    	produitService.addProduit(new Produit(note, priceProduit,nameProduit,dateCreation,quantity/*,image*/));
		return "null"; 
	}
    
    public void removeProduit(long id) 
	{
		
		produitService.DeleteProduit(id); 	 
	}
	
	
	
	public void displayProduit (Produit produit)
	{
		this.setNameProduit(produit.getNameProduit());
		this.setDateCreation(produit.getDateCreation());
		this.setPriceProduit(produit.getPriceProduit());
		this.setQuantity(produit.getQuantity());
		this.setNote(produit.getNote());
		//this.setImage(produit.getImage());
		
		this.setProduitIdToBeUpdated(produit.getIdProduit());
		
		
		
	}
	
	public void updateProduit()
	{
		produitService.addProduit(new Produit(produitIdToBeUpdated,note, priceProduit,nameProduit,dateCreation,quantity/*,image*/));
	}
	

    
    

	
	public ProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(ProduitService produitService) {
		this.produitService = produitService;
	}

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	public Double getPriceProduit() {
		return priceProduit;
	}

	public void setPriceProduit(Double priceProduit) {
		this.priceProduit = priceProduit;
	}

	public String getNameProduit() {
		return nameProduit;
	}

	public void setNameProduit(String nameProduit) {
		this.nameProduit = nameProduit;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public Long getProduitIdToBeUpdated() {
		return produitIdToBeUpdated;
	}

	public void setProduitIdToBeUpdated(Long produitIdToBeUpdated) {
		this.produitIdToBeUpdated = produitIdToBeUpdated;
	}

	public List<Produit> getPts() {
		return pts;
	}

	public void setPts(List<Produit> pts) {
		this.pts = pts;
	}

	public List<Produit> getPropertys() {
		if (this.getTest()==1)
		{
			this.getPts(); 
		}
	
			return produitService.retrieveAllProduit(); 
		
	}

	public void setPropertys(List<Produit> propertys) {
		this.propertys = propertys;
	}

	public String  navigToProduit()
	{
		String navigateTo = "null";
		navigateTo = "/pages/admin/produit.xhtml";
		return navigateTo;	
		
	}
    

}
