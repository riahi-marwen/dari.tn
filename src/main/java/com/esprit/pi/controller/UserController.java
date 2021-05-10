package com.esprit.pi.controller;

import com.esprit.pi.entities.ConfirmationToken;
import com.esprit.pi.entities.User;
import com.esprit.pi.services.ConfirmationTokenService;
import com.esprit.pi.services.UserService;
import lombok.AllArgsConstructor;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Scope(value = "session")
@Controller(value = "UsersController")
@ELBeanName(value = "UsersController")
@Join(path = "/", to = "/Login/accueil.jsf")
@AllArgsConstructor
public class UserController {
	@Autowired
    private  UserService userService;
	@Autowired
    private  ConfirmationTokenService confirmationTokenService;

}