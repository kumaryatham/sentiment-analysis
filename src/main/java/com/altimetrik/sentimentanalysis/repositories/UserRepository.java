package com.altimetrik.sentimentanalysis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.sentimentanalysis.models.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByUsername(String username);
	public void deleteByUsername(String username);
}
