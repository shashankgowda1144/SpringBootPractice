package org.jsp.ums.service;

import java.util.List;
import java.util.Optional;

import org.jsp.ums.UmsApplication;
import org.jsp.ums.dao.UserDao;
import org.jsp.ums.entity.User;
import org.jsp.ums.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UmsApplication umsApplication;

	@Autowired
	UserDao dao;

	UserService(UmsApplication umsApplication) {
		this.umsApplication = umsApplication;
	}

	public ResponseEntity<?> saveUser(User u) {
		User savedUser = dao.saveUser(u);
		ResponseStructure rs = new ResponseStructure();
		rs.setStatus(201);
		rs.setMessage("User Saved Successfully...");
		rs.setBody(savedUser);
		return ResponseEntity.status(201).body(rs);
	}

	public ResponseEntity<?> findAllUsers() {
		List<User> ul = dao.findAllUsers();
		ResponseStructure rs = new ResponseStructure();
		rs.setStatus(200);
		rs.setMessage("All User Found Successfully");
		rs.setBody(ul);

		return ResponseEntity.status(200).body(rs);
	}

	public ResponseEntity<?> findUserById(int id) {

		Optional<User> optional = dao.findUserById(id);

		if (optional.isPresent()) {
			User user = optional.get();
			ResponseStructure rs = new ResponseStructure();
			rs.setStatus(200);
			rs.setMessage("User Found Successfully");
			rs.setBody(user);
			return ResponseEntity.status(200).body(rs);
		} else {
			ResponseStructure rs = new ResponseStructure();
			rs.setStatus(404);
			rs.setMessage("Invalid User Id, Unable to find User");
			rs.setBody(null);
			return ResponseEntity.status(404).body(rs);
		}

	}

	public ResponseEntity<?> deleteUserById(int id) {
		Optional<User> optional = dao.findUserById(id);
		if (optional.isPresent()) {
			dao.deleteUserById(id);
			return ResponseEntity.status(200)
					.body(new ResponseStructure(200, "User Deleted Successfully", "User Deleted"));
		} else {
			return ResponseEntity.status(400)
					.body(new ResponseStructure(400, "Invalid User Id, Unable to Delete", "User Not Deleted"));
		}
	}

}