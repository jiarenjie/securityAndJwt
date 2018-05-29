package com.demo.config;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}