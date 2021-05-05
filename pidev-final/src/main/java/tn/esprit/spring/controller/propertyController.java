package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope(value = "session")
@Controller(value = "propertyController")
@ELBeanName(value = "propertyController")
@Join(path = "/", to = "/login.jsf")

public class propertyController 
{
		

}
