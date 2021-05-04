package edu.esprit.immo.dari.controller;

import edu.esprit.immo.dari.entities.User;
import edu.esprit.immo.dari.entities.forms.AccountRegistrationForm;
import edu.esprit.immo.dari.repository.UserRepository;
import edu.esprit.immo.dari.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@AllArgsConstructor
@SessionAttributes({ "URL_REF", "user", "cart" })
public class UserController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    public String userRegistrationPage(ModelMap modelMap, AccountRegistrationForm accountRegistrationForm) {
        return "register";
    }
    @PostMapping("/register.do")
    public String validateUserRegistrationForm(ModelMap modelMap, HttpServletRequest request,
                                               RedirectAttributes redirectAttr, @Valid AccountRegistrationForm accountRegistrationForm) {
        return userService.createNewAccount(accountRegistrationForm, modelMap, redirectAttr);
    }
    @RequestMapping("/login")
    public String userLoginPage(ModelMap modelMap, HttpServletRequest request) {
        modelMap.put("userLogin", "/login.do");
        System.out.println("Referer: " + request.getHeader("Referer"));
        modelMap.addAttribute("URL_REF", request.getHeader("Referer"));
        return "login";
    }

    @RequestMapping("/account")
    public String userAccountPage(ModelMap modelMap, Principal principal) {
        modelMap.put("welcomeMessage", "Welcome!");
        return "account";
    }
    @RequestMapping("/loginSuccessful")
    public String userLoginSuccessful(@RequestParam String role, ModelMap modelMap, HttpServletRequest request,
                                      Principal principal) {
        User user = userRepo.findByEmail(principal.getName());
        user.setPassword(null);
        modelMap.put("user", user);
        String url_ref = request.getSession().getAttribute("URL_REF").toString();
        String url = null;
        if (url_ref != null) {
            System.out.println("-------------------------------" + url_ref);
            url_ref = "/";
            url = "redirect:" + url_ref;
        } else {
            System.out.println("hello: " + url_ref);
            url = "redirect:/";
        }
        return url;
    }
    @RequestMapping("/logoutSuccessful")
    public String userLogoutValidation(ModelMap modelMap, RedirectAttributes redirectAttr) {
        System.out.println("You have logged out!");
        redirectAttr.addFlashAttribute("LOGOUT_SUCCESSFUL_MESSAGE", "Success! You have successfully logged out.");
        return "redirect:/login";
    }
}