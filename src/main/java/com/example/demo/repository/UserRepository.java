package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User_Entity;

@Repository
public interface UserRepository extends JpaRepository<User_Entity, Integer> {
	
	public User_Entity findByEmail(String email);
	public User_Entity findByEmailAndProvider(String email,String client);		
	public User_Entity findByEmailAndGender(String email,String gender);		
}
