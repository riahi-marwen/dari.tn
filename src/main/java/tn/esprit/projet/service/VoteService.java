package tn.esprit.projet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.projet.modal.Produit;
import tn.esprit.projet.modal.User;
import tn.esprit.projet.modal.Vote;

@Service
public interface VoteService {
	
	    List<Vote> retrieveAllVote();
	    Vote findVoteById(int r);
	    Vote findLikeByProduitAndUser(Produit r, User user);
	    Vote addVoteLike(int idp , int idu, int note);
	  
	     
	

}
