package tn.esprit.projet.service;


import java.util.List;

import tn.esprit.projet.modal.User;

public interface IUserService {
	public User authenticate(String login, String password) ;
	public int addOrUpdateUser(User user) ; 
	public void deleteUserById(int userId);
	public List<User> getAllUsers();	
	
}
