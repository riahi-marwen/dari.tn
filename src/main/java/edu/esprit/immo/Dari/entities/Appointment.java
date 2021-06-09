package edu.esprit.immo.Dari.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.sun.xml.fastinfoset.sax.Properties;

@Entity
public class Appointment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAppt;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_appt")
	private Date dateAppt;
	
	
	
	@Temporal(TemporalType.TIME)
	@Column
	private Date time;
	
	@Column
	private String nomRdv;
	
	@Column 
	private String emailRdv; 
	
	

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

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(int idAppt, Date dateAppt, Date time) {
		super();
		this.idAppt = idAppt;
		this.dateAppt = dateAppt;
		this.time = time;
		
		
		
	}

	public Appointment(int idAppt, Date dateAppt, Date time, String nomRdv, String emailRdv) {
		super();
		this.idAppt = idAppt;
		this.dateAppt = dateAppt;
		this.time = time;
		this.nomRdv = nomRdv;
		this.emailRdv = emailRdv;
	}
	

	
	
	
	
	
	
	
	
	

}
