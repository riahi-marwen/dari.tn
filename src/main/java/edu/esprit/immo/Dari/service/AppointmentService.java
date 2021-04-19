package edu.esprit.immo.Dari.service;

import java.util.List;



import edu.esprit.immo.Dari.entities.Appointment;

public interface AppointmentService {

	public Appointment addAppointment(Appointment appointment);
	public List<Appointment> retrieveAllApp();
	public Appointment updateAppointment (Appointment appointment) ;
}
