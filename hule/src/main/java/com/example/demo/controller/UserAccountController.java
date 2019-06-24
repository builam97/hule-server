package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.ConfirmToken;
import com.example.demo.entities.Users;
import com.example.demo.repository.ConfirmationTokenRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.EmailSenderService;

@Controller
public class UserAccountController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ConfirmationTokenRepository confirmTokenRepository;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
    public Users displayRegistration(Users user)
    {
        return user;
    }

    @PostMapping("/register")
    public String registerUser(Users user)
    {

        Users existingUser = userRepository.findByEmailIgnoreCase(user.getEmail());
        if(existingUser != null)
        {
            return "This email already exists!";
        }
        else
        {
            userRepository.save(user);

            ConfirmToken confirmToken = new ConfirmToken();
            confirmToken.setUserId(user);

            confirmTokenRepository.save(confirmToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("tonriu1110@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
            +"http://localhost:8090/confirm-account?token="+confirmToken.getConfirmToken());

            emailSenderService.sendEmail(mailMessage);

        }

        return "successfulRegisteration";
    }
}
