package com.esprit.pi.entities;

import lombok.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.esprit.pi.payload.UserForm;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@Entity(name = "users")
public class User implements UserDetails,Serializable {

	private static final long serialVersionUID = -1396669830860400871L;
	@Transient
	private boolean active;
	@Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "User's name cannot be empty.")
    private String name;
    @NotEmpty(message = "User's name cannot be empty.")
    private String LastName;
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    @Column(unique = true)
    private Integer phone;
    private String Address;
    @NotNull
    @Column(unique = true)
    private String password;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    @Builder.Default
    private UserRole userRole = UserRole.CLIENT;

    @Builder.Default
    private Boolean locked = false;
 
    @Builder.Default
    private Boolean enabled = false;


	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}

	public User(UserForm userform) {
		this.name = userform.getName();
		LastName = userform.getLastName();
		this.username = userform.getUsername();
		this.Address = userform.getAddress();
		this.password = userform.getPassword();
		this.email = userform.getEmail();
		this.userRole = UserRole.CLIENT;
		this.phone = userform.getPhone();
		this.active = false;
		this.locked = false;
		this.enabled = false;
		this.phone = userform.getPhone();
	}

	public void setActive(boolean active) {
		this.active = active;
	}
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


    public User() {
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		  List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
	        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(this.getUserRole().getType() );
	        grantedAuthorityList.add(simpleGrantedAuthority);
	        return grantedAuthorityList;
	}

}
