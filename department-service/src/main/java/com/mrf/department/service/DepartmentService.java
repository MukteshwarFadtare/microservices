package com.mrf.department.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mrf.department.DAO.UserDTO;
import com.mrf.department.entity.Department;
import com.mrf.department.repository.DepartmentRepository;

@Service
public class DepartmentService {
	Logger log = LoggerFactory.getLogger(DepartmentService.class);
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private RestTemplate restTemplate;

	public Department saveDepartment(Department department) {
		log.info("entered in saveDepartment of DepartmentService");
		return departmentRepository.save(department);
	}

	public Department getDepartment(Long id) {
		log.info("entered in getDepartment of DepartmentService");
		return departmentRepository.findByDepartmentId(id);
	}

	public List<Department> getDepartments() {
		log.info("entered in getDepartments of DepartmentService");
		return departmentRepository.findAll();
	}

	public UserDTO getUser(Long id) {
		log.info("entered in getUser of DepartmentService");
		return restTemplate.getForObject("http://USER-SERVICE/user/getUser/" + id, UserDTO.class);
	}

}
