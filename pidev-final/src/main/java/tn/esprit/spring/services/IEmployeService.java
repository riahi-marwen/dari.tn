package tn.esprit.spring.services;


import java.util.List;


import tn.esprit.spring.entities.Employe;



public interface IEmployeService {
	
	public Employe authenticate(String login, String password) ;
	 
	public int addOrUpdateEmploye(Employe employe) ; 
	public void mettreAjourEmailByEmployeId(String email, int employeId);
	public String getEmployePrenomById(int employeId);
	public void deleteEmployeById(int employeId);
	public int getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
	public List<Employe> getAllEmployes();

	
}
