package com.celinamax.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.celinamax.workshopmongo.domain.Post;
import com.celinamax.workshopmongo.domain.User;
import com.celinamax.workshopmongo.dto.AuthorDTO;
import com.celinamax.workshopmongo.repository.PostRepository;
import com.celinamax.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User noah = new User(null, "Noah Maximiano", "noah@gmail.com");
		User cecilia = new User(null, "Cecília Maximiano", "cecilia@gmail.com");
		User celina = new User(null, "Celina Maximiano", "celina@gmail.com");
		
		userRepository.save(Arrays.asList(noah, cecilia, celina));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(noah));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(noah));
		
				
		postRepository.save(Arrays.asList(post1,post2));
		
		noah.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(noah);
		
		
		
	}

}
