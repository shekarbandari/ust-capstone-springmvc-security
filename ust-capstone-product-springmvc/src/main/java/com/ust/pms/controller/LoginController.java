package com.ust.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ust.pms.model.ChangePassword;
import com.ust.pms.model.ForgotPassword;
import com.ust.pms.util.UserUtil;

@Controller
public class LoginController {
	@Autowired
	private JavaMailSender mailSender;

	SimpleMailMessage msg = new SimpleMailMessage();

	@RequestMapping("/forgotPasswordForm")
	public String forgotPasswordForm(Model model) {
		model.addAttribute("command",new ForgotPassword());
		
		return "forgotPassword";
	}
	
	@RequestMapping(value="/forgotPassword",method=RequestMethod.POST)
	public String forgotPassword(ForgotPassword forgotPassword,Model model) {
		String userName=forgotPassword.getUsername();
		msg.setFrom("shekharbandari@gmail.com");
		msg.setTo(forgotPassword.getEmailId());
		msg.setSubject("Forgot Password using UST Browser ");
			
		msg.setText("http://localhost:6060/changePassword?user="+userName);
		mailSender.send(msg);
		return "login";
	}
	
	@RequestMapping(value="/changePassword",method=RequestMethod.GET)
	public String changePassword(ChangePassword changePassword,Model model) {
model.addAttribute("command",new ChangePassword());
		
		return "changePassword";
	}
	

}
