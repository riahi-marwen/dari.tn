package edu.esprit.immo.dari.controller;

import lombok.Getter;
import lombok.Setter;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.context.FacesContext;

@Scope(value = "session")
@Controller(value = "helloController")
@ELBeanName(value = "helloController")
@Join(path = "/", to = "/login.jsf")
@Getter
@Setter
public class HelloController {


    private String login;
    private String password;
    private Boolean loggedIn;

    public String doLogin() {
        String navigateTo = "null";
        navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
        return navigateTo;
    }

    public String doLogout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }
}
