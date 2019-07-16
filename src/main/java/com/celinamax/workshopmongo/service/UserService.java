package com.celinamax.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celinamax.workshopmongo.domain.User;
import com.celinamax.workshopmongo.dto.UserDTO;
import com.celinamax.workshopmongo.repository.UserRepository;
import com.celinamax.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	public List<User> findAll(){			
		return repo.findAll();
	}

	public User findById(String id) {		
		 User user = repo.findOne(id);
		 if(user == null) {
			 throw new ObjectNotFoundException("Usuário não Cadastrado!");
		 }		 
		 return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);					
	}
	
	public User fromDTO(UserDTO objDto) {		
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());		
	}
	
	public void delete(String id) {
		findById(id);
		repo.delete(id);
	}
	
	public User update(User obj) {
		User newObj = repo.findOne(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(User newObj, User obj) {
		newObj.setNome(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

}
