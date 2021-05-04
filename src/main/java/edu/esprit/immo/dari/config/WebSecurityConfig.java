package edu.esprit.immo.dari.config;

import edu.esprit.immo.dari.entities.RoleType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                // ignore all URLs that start with /resources/ or /static/
                .antMatchers("/resources/**", "/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // CUSTOMER & ADMIN
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/account/change-password").permitAll()
                .antMatchers("/account/recommendations", "/account/profile", "/loginSuccessful").hasAnyAuthority(RoleType.CUSTOMER.toString(), RoleType.ADMIN.toString())
                .and()
                // Login
                .formLogin().loginPage("/login")
//			.usernameParameter("email")
//			.passwordParameter("password")
                .failureUrl("/login?error=true")
                .successHandler(loginSuccessHandler)
                .loginProcessingUrl("/login.do").permitAll().and()
                // Logout
                .logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful").permitAll();
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(14);
    }
}