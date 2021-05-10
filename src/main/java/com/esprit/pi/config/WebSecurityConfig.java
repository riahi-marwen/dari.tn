package com.esprit.pi.config;

import com.esprit.pi.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	  @Autowired
	    private UserService userDetailsService;


	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	    }

	    @Override
	    public void configure(WebSecurity web) {
	        web.ignoring()
	                // ignore all URLs that start with /resources/ or /static/
	                .antMatchers("/resources/**", "/static/**,/webapp/**");
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	                // CUSTOMER & ADMIN
	                .antMatchers("/").permitAll()
	                .antMatchers("/Login/signup.jsf").permitAll()
	                .antMatchers("/Login/signin.jsf").permitAll()
	                .and()
	                // Login
	                .formLogin().loginPage("/Login/signin.jsf")
				.usernameParameter("username")
				.passwordParameter("password")
	                .and()
	                .csrf().disable();
	                // Logout
	    }

	    @Bean
	    public BCryptPasswordEncoder getPasswordEncoder() {
	        return new BCryptPasswordEncoder(14);
	    }
}