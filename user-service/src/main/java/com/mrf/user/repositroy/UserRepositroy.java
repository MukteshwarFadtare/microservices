package com.mrf.user.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrf.user.entity.User;

@Repository
public interface UserRepositroy extends JpaRepository<User, Long> {

	User findByUserId(Long userId);

}
