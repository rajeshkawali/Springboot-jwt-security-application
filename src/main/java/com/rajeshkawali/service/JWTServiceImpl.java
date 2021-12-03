package com.rajeshkawali.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajeshkawali.entity.User;
import com.rajeshkawali.repository.JWTRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class JWTServiceImpl implements JWTService {
	
	public static final String CLASS_NAME = JWTServiceImpl.class.getName();

	@Autowired
	private JWTRepository repository;
	
	@Override
	public List<User> getAllUsers() {
		log.info(CLASS_NAME+".getAllUsers()");
		return repository.findAll();
	}

}
