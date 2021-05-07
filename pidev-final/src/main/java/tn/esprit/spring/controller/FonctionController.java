package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope(value = "session")
@Controller(value = "fonctionControlle")
@ELBeanName(value = "fonctionControlle")
@Join(path = "/rent.jsf", to = "/rent.jsf")


public class FonctionController 
{


	public String recherchee()
	{
		String navigateTo = "null";
		navigateTo = "/pages/admin/login.xhtml";
		return navigateTo;	
		
	}
	
}
