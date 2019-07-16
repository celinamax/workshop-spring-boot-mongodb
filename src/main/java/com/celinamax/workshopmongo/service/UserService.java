package com.celinamax.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celinamax.workshopmongo.domain.User;
import com.celinamax.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	public List<User> findAll(){			
		return repo.findAll();
	}

}
