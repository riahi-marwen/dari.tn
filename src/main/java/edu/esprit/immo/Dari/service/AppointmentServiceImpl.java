package edu.esprit.immo.Dari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.esprit.immo.Dari.entities.Appointment;
import edu.esprit.immo.Dari.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired 
	AppointmentRepository appointmentRepository;

	@Override
	public Appointment addAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);		
		return appointment ; 
	}

	@Override
	public List<Appointment> retrieveAllApp() {
		
		return (List<Appointment>) appointmentRepository.findAll() ;
	}

	public Appointment updateAppointment(Appointment appointment) {
		
		appointmentRepository.save(appointment);
		
		return null;
	}

	@Override
	public void deleteApp(String id) {

		 
		appointmentRepository.deleteById(Integer.parseInt(id));
		
	}

	@Override
	public Appointment retrieveApp(String id) {
		
		return appointmentRepository.findById(Integer.parseInt(id)).orElse(null);
	}
	
	
	

}
