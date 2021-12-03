package com.rajeshkawali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajeshkawali.entity.User;

@Repository
public interface JWTRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);
}
