package com.mrf.user.departmentfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mrf.user.VO.Department;


@FeignClient(name="DEPARTMENT-SERVICE")
public interface FeignDeparmentService {
	
	
	@GetMapping("/departments/{id}")
	public Department getDepartment(@PathVariable("id") Long id);

}
