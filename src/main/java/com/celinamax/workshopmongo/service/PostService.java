package com.celinamax.workshopmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celinamax.workshopmongo.domain.Post;
import com.celinamax.workshopmongo.repository.PostRepository;
import com.celinamax.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;	

	public Post findById(String id) {		
		 Post post = repo.findOne(id);
		 if(post == null) {
			 throw new ObjectNotFoundException("Post não Encontrado!");
		 }		 
		 return post;
	}	
	
}
