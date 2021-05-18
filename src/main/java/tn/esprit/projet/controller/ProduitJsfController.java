package tn.esprit.projet.controller;

/*import java.util.Date;
import java.util.List;


import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.projet.modal.Produit;
import tn.esprit.projet.modal.UploadFile;
import tn.esprit.projet.service.ProduitService;
import tn.esprit.projet.service.ProduitServiceImpl;
import tn.esprit.projet.service.UserService;
import tn.esprit.spring.entities.Property;

@Scope(value = "session")
@Controller(value = "venteProduitController")
@ELBeanName(value = "venteProduitController")
public class ProduitJsfController {
	@Autowired
	ProduitService produitService;
	@Autowired
	UserService userService;
	@Autowired
	UserJsfController userJsfController;
	private Double note;
    private Double priceProduit;
    private String nameProduit;
    private UploadFile image ;
    private Date dateCreation;
    private  int quantity;
    private int  test  ;
    private Long produitIdToBeUpdated; 
    private List<Produit> pts;
    
    
    public Produit addProduit()
	{
    	produitService.addProduit(new Produit(nameProduit, priceProduit, note, quantity,));
		return "null"; 
	}
    public List<Produit> getProduits() 
	{
		if (this.getTest()==1)
		{
			this.getPts(); 
		}
	
			return produitService.retrieveAllProduit(); 
			
	
	}
    public void removeProperty(Long id) 
	{
		
    	produitService.DeleteProduit(id); 	 
	}
    
    public void displayProduit (Produit produit)
	{
		this.setNameProduit(produit.getNameProduit());
		this.setPriceProduit(produit.getPriceProduit());
		
		this.setQuantity(produit.getQuantity());
		this.setProduitIdToBeUpdated(produit.getIdProduit());
		
	}
	public void setProduitIdToBeUpdated(Long produitIdToBeUpdated) {
		this.produitIdToBeUpdated = produitIdToBeUpdated;
	}
	public void updateProperty()
	{
		produitService.addProduit(new Property(produitIdToBeUpdated, name_Property, type, price, adresse, city, description, surface, nbPiece));
	}
    
	
	
	public List<Produit> getPts() {
		return pts;
	}
	public void setPts(List<Produit> pts) {
		this.pts = pts;
	}
	public ProduitService getProduitService() {
		return produitService;
	}
	public void setProduitService(ProduitService produitService) {
		this.produitService = produitService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public UserJsfController getUserJsfController() {
		return userJsfController;
	}
	public void setUserJsfController(UserJsfController userJsfController) {
		this.userJsfController = userJsfController;
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
	public UploadFile getImage() {
		return image;
	}
	public void setImage(UploadFile image) {
		this.image = image;
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
    
    
	
}*/
