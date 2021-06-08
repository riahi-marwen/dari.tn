package tn.esprit.projet.service;

import java.util.List;

import tn.esprit.projet.modal.Category;
import tn.esprit.projet.modal.Produit;
import tn.esprit.projet.modal.UploadFile;
import tn.esprit.projet.modal.User;


public interface ProduitService {

	public String addProduit(Produit produit);
	public String DeleteProduit(long id);
	public String updateProduit(Produit produit);
	public List<Produit> retrieveAllProduit();
	public UploadFile saveImage(UploadFile p);
	public Produit findById(long id);
    public List<Produit> getBestProduct();
	public List<Produit> retrieveProduitByNom(String l, Category f);
	//String AjouterPrduit (Produit  produit);
	/*public void deleteProduitById(Long idProduit);*/
	public List<Produit> triNote();
	
	
	 
}
