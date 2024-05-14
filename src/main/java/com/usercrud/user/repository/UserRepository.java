package com.usercrud.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usercrud.user.model.User;


public interface UserRepository extends JpaRepository<User, Long>{



}
