package com.rajeshkawali.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajeshkawali.entity.LoginRequest;
import com.rajeshkawali.entity.User;
import com.rajeshkawali.service.JWTService;
import com.rajeshkawali.util.JwtUtil;

import lombok.extern.log4j.Log4j2;


@Log4j2
@RestController
public class JWTController {
	
	public static final String CLASS_NAME = JWTController.class.getName();
	
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JWTService jwtService;

    @GetMapping("/")
    public String welcomeToJWT() {
    	log.info(CLASS_NAME+".welcomeToJWT()");
        return "Welcome to JWT Example";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody LoginRequest loginRequest) throws Exception {
    	log.info(CLASS_NAME+".generateToken():ENTER");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Inavalid username/password");
        }
        log.info(CLASS_NAME+".generateToken():EXIT");
        return jwtUtil.generateToken(loginRequest.getUsername());
    }
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
    	log.info(CLASS_NAME+".getAllUsers()");
        return jwtService.getAllUsers();
    }
}
