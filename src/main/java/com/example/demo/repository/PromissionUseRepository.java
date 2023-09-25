package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User_Entity_Permission_to_use;

public interface PromissionUseRepository extends JpaRepository<User_Entity_Permission_to_use, Integer>{

}
