package com.service.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.user.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
