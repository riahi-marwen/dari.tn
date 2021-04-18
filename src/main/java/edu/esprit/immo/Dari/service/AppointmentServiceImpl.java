package edu.esprit.immo.Dari.service;

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
	
	
	

}
