package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User_Entity;
import com.example.demo.repository.UserRepository;

//이건 규칙이므로 그냥 외울것
// 시큐리티 설정에서 loginprocessingurl("/login")
// login 요청이 오면 자동으로 userdetailsservice 타입의 ioc로 되어있는 loaduserbyusername 함수가 실행됨
// 함수 종료시 Principal 어노테이션이 만들어짐
@Service
public class PrincipalDetailsService implements UserDetailsService{

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	User_Entity user = repository.findByEmailAndProvider(username,"client");
	
	if(user != null) {
		
		return new PrincipalDetails(user);
	}
	
		return null;
	}

}
