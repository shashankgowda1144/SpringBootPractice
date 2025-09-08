package org.jsp.ums.controller;

import org.jsp.ums.entity.User;
import org.jsp.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@PostMapping("/users")
	public ResponseEntity<?> saveUser(@RequestBody User u) {
		return service.saveUser(u);
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> findAllUsers(){
		return service.findAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> findUserById(@PathVariable int id){
		return service.findUserById(id);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable int id){
		return service.deleteUserById(id);
	}

}