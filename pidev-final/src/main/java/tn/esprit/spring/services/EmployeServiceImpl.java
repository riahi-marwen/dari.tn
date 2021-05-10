package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EmployeRepository;


@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;
	

	@Override
	public User authenticate(String login, String password) {
		return employeRepository.getEmployeByEmailAndPassword(login, password);
	}

	@Override
	public int addOrUpdateEmploye(User employe) {
		employeRepository.save(employe);
		return employe.getId();
	}


	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		User employe = employeRepository.findById(employeId).get();
		employe.setEmail(email);
		employeRepository.save(employe);

	}



	public String getEmployePrenomById(int employeId) {
		User employeManagedEntity = employeRepository.findById(employeId).get();
		return employeManagedEntity.getPrenom();
	}
	 
	public void deleteEmployeById(int employeId)
	{
		User employe = employeRepository.findById(employeId).get();
		employeRepository.delete(employe);
	}

	
	public int getNombreEmployeJPQL() {
		return employeRepository.countemp();
	}

	public List<String> getAllEmployeNamesJPQL() {
		return employeRepository.employeNames();

	}



	public List<User> getAllEmployes() {
		return (List<User>) employeRepository.findAll();
	}

}
