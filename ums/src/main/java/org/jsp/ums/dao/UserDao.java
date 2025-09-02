package org.jsp.ums.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.ums.entity.User;
import org.jsp.ums.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	UserRepository repository;

	public User saveUser(User u) {
		return repository.save(u);
	}

	public List<User> findAllUsers() {
		return repository.findAll();
	}

	public Optional<User> findUserById(int id) {
		return repository.findById(id);
	}

	public void deleteUserById(int id) {
		repository.deleteById(id);
	}

}