package com.esprit.pi.config;

import com.esprit.pi.services.UserService;
import lombok.AllArgsConstructor;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
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
	  @Autowired
	  private  BCryptPasswordEncoder bCryptPasswordEncoder ;

	    @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    public void configure(WebSecurity web) {
	        web.ignoring()
	                // ignore all URLs that start with /resources/ or /static/
	                .antMatchers("/resources/**", "/static/**,/webapp/**");
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http.authorizeRequests().antMatchers("/javax.faces.resource/**")
	        .permitAll()       ; 
	  
	        http.authorizeRequests()
	                // CUSTOMER & ADMIN
	                .antMatchers("/").permitAll()
	                .antMatchers("/Login/login.jsf").permitAll()
	                .antMatchers("/Login/signup.jsf").permitAll()
	                .antMatchers("/Login/signin.jsf").permitAll()
					.and()
					.formLogin().loginPage("/Login/signin.jsf")
						.defaultSuccessUrl("/Login/singup.xhtml", true)
						.usernameParameter("username")
						.passwordParameter("password").permitAll() 
						.and()
						.rememberMe().key("uniqueAndSecret")
					.and()
						.logout()
						.logoutSuccessUrl("/login.xhtml")
						.deleteCookies("JSESSIONID")
						.and()
						.csrf().disable();
	
	    }

	    @Autowired
	    @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception
	    {
	        auth
	                .parentAuthenticationManager(authenticationManagerBean())
	                .userDetailsService(userDetailsService)
	                .passwordEncoder(bCryptPasswordEncoder);

	    } 
}