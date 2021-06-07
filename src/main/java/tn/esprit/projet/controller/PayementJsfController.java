package tn.esprit.projet.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.projet.modal.Produit;
import tn.esprit.projet.modal.User;
import tn.esprit.projet.service.PayementService;

public class PayementJsfController {
	
	@Autowired
	PayementService payementService;
	
	private Date createDate;
	private Integer quantity;
	private Double amount;
	private User user ;
	private Produit product ;
}
