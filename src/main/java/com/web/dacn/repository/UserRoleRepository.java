package com.web.dacn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.dacn.entity.user.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

}
