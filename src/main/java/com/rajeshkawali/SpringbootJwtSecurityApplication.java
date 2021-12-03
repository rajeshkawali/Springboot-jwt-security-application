package com.rajeshkawali;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rajeshkawali.entity.User;
import com.rajeshkawali.repository.JWTRepository;

@SpringBootApplication
public class SpringbootJwtSecurityApplication {

	@Autowired
    private JWTRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJwtSecurityApplication.class, args);
	}

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "rajesh", "rajesh", "rajesh@gmail.com"),
                new User(102, "keshav", "keshav", "keshav@gmail.com"),
                new User(103, "kiran", "kiran", "kiran@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
}
