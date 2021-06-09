package edu.esprit.immo.Dari.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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
		this.sendSimpleMessage(appointment);
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
	public void deleteApp(int id) {

		 
		appointmentRepository.deleteById(id);
		
	}

	@Override
	public Appointment retrieveApp(String id) {
		
		return appointmentRepository.findById(Integer.parseInt(id)).orElse(null);
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	    
	    mailSender.setUsername("daritn10@gmail.com");
	    mailSender.setPassword("qcezqkvgkvqsgrmy");
	    
	    java.util.Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
	    return mailSender;
	}
	
    public void sendSimpleMessage(
    	      Appointment appointment) {
    	        SimpleMailMessage message = new SimpleMailMessage(); 
    	        message.setFrom("daritn10@gmail.com");
    	        message.setTo(appointment.getEmailRdv()); 
    	        message.setSubject("Rappel rendez-vous"); 
    	        message.setText("Bonjour Monsieur/Madame "+appointment.getNomRdv()+"/n"+ " Vous avez un rendez-vous a "+ appointment.getDateAppt()+""+appointment.getTime());
    	        getJavaMailSender().send(message);
    	        
    	    }
	
	

}
