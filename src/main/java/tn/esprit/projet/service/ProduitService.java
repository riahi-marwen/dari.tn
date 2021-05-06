package tn.esprit.projet.service;

import java.util.List;

import tn.esprit.projet.modal.Category;
import tn.esprit.projet.modal.Produit;
import tn.esprit.projet.modal.UploadFile;


public interface ProduitService {

	Produit addProduit(Produit produit);
	String DeleteProduit(long id);
	Produit updateProduit(Produit produit);
	List<Produit> retrieveAllProduit();
	UploadFile saveImage(UploadFile p);
	Produit findById(long id);
    List<Produit> getBestProduct();
	List<Produit> retrieveProduitByNom(String l, Category f);
}
