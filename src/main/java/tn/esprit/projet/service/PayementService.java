package tn.esprit.projet.service;

import java.util.List;

import tn.esprit.projet.modal.Payement;


public interface PayementService {

	Payement addPayement(Payement payement);
	

	Payement updatePayement(Payement payement);

	Payement findPayementById(long id);
	String callStripeAPIBuy(Payement payement);


	List<Payement> retrievePayements();
	


}
