package tn.esprit.projet.modal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_claim")
public class Claim implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private int id_claim;
	
	@Column (name="description")
	private String description;
	
	@Column (name="date")
	private Date date;
	@Column (name="state")
	private boolean state;
	
	
	
	@JsonIgnore
	@ManyToOne
	private User User;
	
	public Claim() {
		super();
	}


	
	

	



	





	public int getId_claim() {
		return id_claim;
	}
	
	



	public void setId_claim(int id_claim) {
		this.id_claim = id_claim;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public boolean getState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}


	



	public User getUser() {
		return User;
	}


	public void setUser(User user) {
		User = user;
	}





	public Claim(String description, Date date, boolean state, tn.esprit.projet.modal.User user) {
		super();
		this.description = description;
		this.date = date;
		this.state = state;
		User = user;
	}















	@Override
	public String toString() {
		return "Claim [id_claim=" + id_claim + ", description=" + description + ", date=" + date
				+ ", state=" + state  + ", User=" + User + "]";
	}


	
	
	

		}