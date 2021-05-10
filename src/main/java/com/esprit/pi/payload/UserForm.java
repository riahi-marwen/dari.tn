package com.esprit.pi.payload;


import org.springframework.stereotype.Component;

import com.esprit.pi.entities.UserRole;
@Component
public class UserForm {
    private Long id;

    private String name;
    private String LastName;


    private String username;
    private Integer phone;
    private String Address;
    private String password;
    private String email;
    private UserRole userRole = UserRole.CLIENT;
    private Boolean locked = false;
    private Boolean enabled = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public UserForm(Long id, String name, String lastName, String username, Integer phone, String address, String password,
			String email, UserRole userRole, Boolean locked, Boolean enabled) {
		this.id = id;
		this.name = name;
		LastName = lastName;
		this.username = username;
		this.phone = phone;
		Address = address;
		this.password = password;
		this.email = email;
		this.userRole = userRole;
		this.locked = locked;
		this.enabled = enabled;
	}

	public UserForm() {
	}
    

}
