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
	
	@Column
	private String password;
	
	@Column
	private String time;
	
	@ManyToOne
	User users ;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(int idAppt, Date dateAppt, String password, String time, User users) {
		super();
		this.idAppt = idAppt;
		this.dateAppt = dateAppt;
		this.password = password;
		this.time = time;
		this.users = users;
	}
	
	
	
	
	
	
	
	

}
