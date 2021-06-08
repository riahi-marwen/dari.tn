package tn.esprit.projet.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import tn.esprit.projet.modal.Facture;
import tn.esprit.projet.modal.Produit;
import tn.esprit.projet.modal.User;
import tn.esprit.projet.service.FactureService;

@Scope(value = "session")
@Controller(value = "billController") // Name of the bean in Spring IoC
@ELBeanName(value = "billController") // Name of the bean used by JSF
@Join(path = "/produit", to = "/bill.jsf")

public class FactureJsfController {
	@Autowired
	FactureService factureService;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	 private Date dateCreation ;
	 private  double amount ;
	 private Produit idProduit;
	 private User user;
	 private List<Facture> bill;
	public FactureService getFactureService() {
		return factureService;
	}
	public void setFactureService(FactureService factureService) {
		this.factureService = factureService;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Produit getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Produit idProduit) {
		this.idProduit = idProduit;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Facture> getBill() {
		return bill;
	}
	public void setBill(List<Facture> bill) {
		this.bill = bill;
	}
	 
}
