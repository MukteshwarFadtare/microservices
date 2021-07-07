package com.mrf.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrf.admin.VO.ResponseTemplateVO;
import com.mrf.admin.service.UserFeignClient;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

	Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/getUser/{userId}")
	public ResponseTemplateVO getUser(@PathVariable("userId") Long userId) {
		log.info("entered in getUser() of AdminController");
		return userFeignClient.getUser(userId);

	}

}
