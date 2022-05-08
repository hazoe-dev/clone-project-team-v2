package com.web.dacn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.dacn.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByUsernameAndStatus(String username, int status);
	User findByUsername(String username);
	public Optional<User> findByUsernameIgnoreCase(String username);
	public Optional<User> findByEmail(String email);
}