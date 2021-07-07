package com.mrf.department.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrf.department.DAO.UserDTO;
import com.mrf.department.entity.Department;
import com.mrf.department.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	Logger log = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("entered in saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/all")
	public List<Department> getDepartments() {
		log.info("entered in getDepartments of DepartmentController");
		return departmentService.getDepartments();
	}

	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") Long id) {
		log.info("entered in getDepartment of DepartmentController");
		return departmentService.getDepartment(id);
	}
	
	@GetMapping("/user/{id}")
	public UserDTO getUserInDepartment(@PathVariable("id") Long id) {
		log.info("entered in getDepartment of DepartmentController");
		return departmentService.getUser(id);
	}

}
