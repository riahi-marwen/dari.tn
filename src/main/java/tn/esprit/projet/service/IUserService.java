package tn.esprit.projet.service;

import tn.esprit.projet.modal.User;

public interface IUserService {
	public User authenticate(String login, String password) ;

	
}
