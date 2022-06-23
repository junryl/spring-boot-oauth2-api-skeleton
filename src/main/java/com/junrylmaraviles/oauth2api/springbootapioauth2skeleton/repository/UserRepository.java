package com.junrylmaraviles.oauth2api.springbootapioauth2skeleton.repository;

import com.junrylmaraviles.oauth2api.springbootapioauth2skeleton.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}