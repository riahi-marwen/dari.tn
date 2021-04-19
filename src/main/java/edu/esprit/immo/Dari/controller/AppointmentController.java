package edu.esprit.immo.Dari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.esprit.immo.Dari.entities.Appointment;
import edu.esprit.immo.Dari.service.AppointmentService;
import edu.esprit.immo.Dari.service.AppointmentServiceImpl;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentServiceImpl sapp;
	
	@PostMapping("/addAppointment")
	public void addAppointment(@RequestBody Appointment appointment) {
		sapp.addAppointment(appointment);
	}

}
