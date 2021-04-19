package edu.esprit.immo.Dari.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	
}
