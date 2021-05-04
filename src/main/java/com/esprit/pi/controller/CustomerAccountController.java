package com.esprit.pi.controller;

import com.esprit.pi.entities.User;
import com.esprit.pi.services.PasswordResetTokenService;
import com.esprit.pi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/account")
public class CustomerAccountController {
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordResetTokenService passwordResetTokenService;


	@RequestMapping("/profile")
	public String getAccountProfile(ModelMap modelMap, HttpSession session) {
		String newEmail = (String) modelMap.get("newEmail");
		if (newEmail != null) {
			User user = userService.getCurrentUserByEmail(newEmail);
			session.setAttribute("user", user);
		}
		return "account-profile";
	}

	@PostMapping("/password/update")
	public String updateAccountPassword(RedirectAttributes redirectAttr, HttpServletRequest request,
			Principal principal) {
		userService.updateUserAccountPassword(request, redirectAttr, principal.getName());
		return "redirect:/account/profile";
	}

	@PostMapping("/email/update")
	public String updateAccountEmail(RedirectAttributes redirectAttr, HttpServletRequest request, Principal principal) {
		userService.updateUserAccountEmail(request, redirectAttr, principal.getName());
		return "redirect:/account/profile";
	}


	@RequestMapping("/password/reset")
	@PostMapping("/password/reset.do")
	public String changePassword(ModelMap modelMap, HttpServletRequest request) {
		if (request.getParameter("email") != null) {
			return passwordResetTokenService.resetPasswordByEmail(request.getParameter("email"), modelMap);
		}
		return "change-password";
	}

	@RequestMapping("/password/reset/")
	public String resetPassword(@RequestParam String token, ModelMap modelMap) {
		if (token != null) {
			passwordResetTokenService.verifyToken(token, modelMap);
		}
		return "reset-password";
	}

	@PostMapping("/password/reset/change.do")
	public String updatePassword(ModelMap modelMap, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		return passwordResetTokenService.updatePassword(modelMap, request, redirectAttributes);
	}

}