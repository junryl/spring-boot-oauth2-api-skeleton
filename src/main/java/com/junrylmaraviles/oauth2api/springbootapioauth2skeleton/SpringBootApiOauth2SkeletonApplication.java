package com.junrylmaraviles.oauth2api.springbootapioauth2skeleton;

import com.junrylmaraviles.oauth2api.springbootapioauth2skeleton.entity.User;
import com.junrylmaraviles.oauth2api.springbootapioauth2skeleton.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootApiOauth2SkeletonApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(1, "user1", "pass1", "user1@gmail.com"),
				new User(2, "user2", "pass2", "user2@gmail.com"),
				new User(3, "user3", "pass3", "user3@gmail.com"),
				new User(4, "user4", "pass4", "user4@gmail.com"),
				new User(5, "user5", "pass5", "test5@gmail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiOauth2SkeletonApplication.class, args);
	}

}
