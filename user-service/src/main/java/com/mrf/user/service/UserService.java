package com.mrf.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrf.user.DAO.UserDTO;
import com.mrf.user.VO.Department;
import com.mrf.user.VO.ResponseTemplateVO;
import com.mrf.user.departmentfeign.FeignDeparmentService;
import com.mrf.user.entity.User;
import com.mrf.user.repositroy.UserRepositroy;

@Service
public class UserService {

	Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepositroy userRepositroy;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private FeignDeparmentService feignClient;

	public User saveUser(User user) {
		log.info("entered in saveUser of UserService");
		return userRepositroy.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("entered in getUserWithDepartment of UserService");
		try {
			ResponseTemplateVO vo = new ResponseTemplateVO();
			User user = userRepositroy.findByUserId(userId);
			Department department = feignClient.getDepartment(user.getDepartmentId());

			vo.setUser(user);
			vo.setDepartment(department);
			return vo;
		} catch (Exception e) {
			System.out.println("eroorrrrrrrr " + e.getLocalizedMessage() + " tosstring :-  " + e.toString() + " MSG :  "
					+ e.getMessage());
		}
		return null;
	}

	public UserDTO getUserById(Long userId) {
		log.info("entered in getUserWithDepartment of UserService");
		User user = userRepositroy.findByUserId(userId);
		return objectMapper.convertValue(user, UserDTO.class);

	}

}
