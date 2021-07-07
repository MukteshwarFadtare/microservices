package com.mrf.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrf.user.DAO.UserDTO;
import com.mrf.user.VO.ResponseTemplateVO;
import com.mrf.user.entity.User;
import com.mrf.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		log.info("entered in saveUser of UserController");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{userId}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("userId") Long userId) {
		log.info("entered in getUserWithDepartment of UserController");	
		return userService.getUserWithDepartment(userId);
	}
	
	
	@GetMapping("/getUser/{userId}")
	public UserDTO getUserById(@PathVariable("userId") Long userId) {
		log.info("entered in getUserById of UserController");	
		return userService.getUserById(userId);
	}

}
