package com.mrf.proxy.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod() {

		return "User service is taking longer than expected please try after somethime";
	}

	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod() {

		return "department service is taking longer than expected please try after somethime";
	}

	@GetMapping("/adminServiceFallBack")
	public String adminServiceFallBackMethod() {

		return "admin service is taking longer than expected please try after somethime";
	}

}
