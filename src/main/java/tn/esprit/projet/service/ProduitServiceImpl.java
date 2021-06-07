package tn.esprit.projet.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stripe.model.Product;

import tn.esprit.projet.modal.Category;
import tn.esprit.projet.modal.Produit;
import tn.esprit.projet.modal.UploadFile;
import tn.esprit.projet.repository.ProduitRepository;
import tn.esprit.projet.repository.UploadFileRepository;


@Service("produitService")
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;

	@Autowired
	UploadFileRepository  uploadFileRepository;
	
	@Override
	public String addProduit(Produit produit) {
		produitRepository.save(produit) ;
		return "fonction";
	}
	@Override
	public String DeleteProduit(long id) {
		produitRepository.delete(produitRepository.findById((long) id).get());
		return "Deleted"; 

	}

	@Override
	public String updateProduit (Produit produit) {
		 produitRepository.save(produit);
		 return "valid";
	}
	
	@Override
	public List<Produit> retrieveAllProduit() {
		List<Produit> produits=(List<Produit>)produitRepository.findAll();
		return produits;
	}
	
	@Override
	public List<Produit> getBestProduct() {
		List<Produit> produits=(List<Produit>)produitRepository.getBestProduct();
		return produits;
	}
	
	

	@Override
	public UploadFile saveImage(UploadFile p) {
		return uploadFileRepository.save(p);

	}

	@Override
	public Produit findById(long id) {
		return produitRepository.findById(id).orElse(null);
	}
	@Override
	public List<Produit> retrieveProduitByNom(String l, Category f) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	


}
