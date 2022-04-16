package tn.esprit.spring.services;


import java.util.List;


import tn.esprit.spring.entities.User;



public interface IEmployeService {
	
	public User authenticate(String login, String password) ;
	 
	public int addOrUpdateEmploye(User employe) ; 
	public void mettreAjourEmailByEmployeId(String email, int employeId);
	public String getEmployePrenomById(int employeId);
	public void deleteEmployeById(int employeId);
	public int getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
	public List<User> getAllEmployes();

	
}
