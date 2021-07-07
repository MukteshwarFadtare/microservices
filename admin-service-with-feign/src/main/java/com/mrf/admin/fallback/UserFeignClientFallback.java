package com.mrf.admin.fallback;

import org.springframework.stereotype.Component;

import com.mrf.admin.VO.ResponseTemplateVO;
import com.mrf.admin.service.UserFeignClient;

@Component
public class UserFeignClientFallback implements UserFeignClient {

	@Override
	public ResponseTemplateVO getUser(Long userId) {
		return null;
	}

    
}