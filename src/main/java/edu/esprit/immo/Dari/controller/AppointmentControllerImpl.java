package edu.esprit.immo.Dari.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.esprit.immo.Dari.entities.Appointment;

import edu.esprit.immo.Dari.service.AppointmentService;

@ManagedBean
@Scope(value = "session")
@Component(value = "appCo")
@ELBeanName(value = "appCo")
@Join(path = "/", to = "/welcome.jsf")
public class AppointmentControllerImpl {

	@Autowired
	AppointmentService appSer ; 
	
	public List<Appointment> appointment ;
	
	public List<Appointment> getAppointments (){
		return appSer.retrieveAllApp();
	}
	 
	public int idAppt; 
	public Date dateAppt ; 
	public Date time ;
	public String nomRdv ;
	public String emailRdv ; 
	public List<Appointment> appointments ;
	public Appointment selectedAppointements ;

	public List<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
	public int getIdAppt() {
		return idAppt;
	}
	public void setIdAppt(int idAppt) {
		this.idAppt = idAppt;
	}
	public Date getDateAppt() {
		return dateAppt;
	}
	public void setDateAppt(Date dateAppt) {
		this.dateAppt = dateAppt;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getNomRdv() {
		return nomRdv;
	}
	public void setNomRdv(String nomRdv) {
		this.nomRdv = nomRdv;
	}
	public String getEmailRdv() {
		return emailRdv;
	}
	public void setEmailRdv(String emailRdv) {
		this.emailRdv = emailRdv;
	}
	public Appointment getSelectedAppointements() {
		return selectedAppointements;
	}
	public void setSelectedAppointements(Appointment selectedAppointements) {
		this.selectedAppointements = selectedAppointements;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public AppointmentControllerImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppointmentControllerImpl(int idAppt, Date dateAppt, Date time, String nomRdv, String emailRdv) {
		super();
		this.idAppt = idAppt;
		this.dateAppt = dateAppt;
		this.time = time;
		this.nomRdv = nomRdv;
		this.emailRdv = emailRdv;
	}
	
/*--------------CRUD -----------*/
	
	public void addAppointment() {
		appSer.addAppointment(new Appointment(idAppt,dateAppt,time,nomRdv,emailRdv));
	}
	
	public void updateAppointment() {
		appSer.addAppointment(new Appointment(idAppt,dateAppt,time,nomRdv,emailRdv));
		
		}
	public void removeAppointment (int id) 
	{
		appSer.deleteApp(id);
	}
	
	public void displayAppt (Appointment app) {
		this.setIdAppt(app.getIdAppt());
		this.setDateAppt(app.getDateAppt());
		this.setTime(app.getTime());
		this.setNomRdv(app.getNomRdv());
		this.setEmailRdv(app.getEmailRdv());

	
	}
	
	
}
