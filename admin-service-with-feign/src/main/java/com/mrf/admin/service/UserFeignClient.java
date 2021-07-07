package com.mrf.admin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mrf.admin.VO.ResponseTemplateVO;
import com.mrf.admin.constants.AdminConstants;
import com.mrf.admin.fallback.UserFeignClientFallback;

@FeignClient(name=AdminConstants.USER_SERVICE_CONSTANT,fallback = UserFeignClientFallback.class)
public interface UserFeignClient {
	
	@GetMapping("/user/{userId}")
	public ResponseTemplateVO getUser(@PathVariable("userId") Long userId);

}
