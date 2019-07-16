package com.celinamax.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.celinamax.workshopmongo.domain.User;
import com.celinamax.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User noah = new User(null, "Noah Maximiano", "noah@gmail.com");
		User cecilia = new User(null, "Cecília Maximiano", "cecilia@gmail.com");
		User celina = new User(null, "Celina Maximiano", "celina@gmail.com");
		
		userRepository.save(Arrays.asList(noah, cecilia, celina));
		
		
		
	}

}
