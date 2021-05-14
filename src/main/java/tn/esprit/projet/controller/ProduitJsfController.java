package tn.esprit.projet.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.projet.service.ProduitService;
import tn.esprit.projet.service.ProduitServiceImpl;
import tn.esprit.projet.service.UserService;

@Scope(value = "session")
@Controller(value = "venteController")
@ELBeanName(value = "venteController")
public class ProduitJsfController {
	@Autowired
	ProduitService produitService;
	@Autowired
	UserService userService;
	@Autowired
	UserJsfController userJsfController;
	private static final Logger l = LogManager.getLogger(ProduitServiceImpl.class);

}
