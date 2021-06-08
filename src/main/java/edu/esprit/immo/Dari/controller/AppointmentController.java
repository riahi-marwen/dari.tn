package edu.esprit.immo.Dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.esprit.immo.Dari.entities.Appointment;
import edu.esprit.immo.Dari.service.AppointmentServiceImpl;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentServiceImpl sapp;
	
	@PostMapping("/addAppointment")
	public void addAppointment(@RequestBody Appointment appointment) {
		sapp.addAppointment(appointment);
	}

	@PutMapping("/updateAppointment")
	public void updateAppointment (@RequestBody Appointment appointment)
	{
		sapp.updateAppointment(appointment);
	}
	
	
	@DeleteMapping("/deleteApp/{appId}")

	public void deleteApp (@PathVariable("appId") int idAppt)
	{
		sapp.deleteApp(idAppt);
		
	}
	
	
	@GetMapping("/retrieve-all-appointment")
	public List<Appointment> getAppointments() {
	List<Appointment> list = sapp.retrieveAllApp();
	return list;
	}
	
	
	@GetMapping("/retrieve-app/{appId}")
	
	public Appointment retrieveAppointment (@PathVariable("appId") String idAppt)
	{
		return sapp.retrieveApp(idAppt);
	}
	
	
	




}
