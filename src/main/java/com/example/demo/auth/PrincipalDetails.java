package com.example.demo.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.example.demo.entity.User_Entity;

import lombok.Data;


@Data
public class PrincipalDetails implements UserDetails,OAuth2User {

	private User_Entity user;
	
	private Map<String, Object> attributes;
	
	
	// 일반 로그인 객체
	public PrincipalDetails(User_Entity user) {
		
		this.user = user;
		
	}
	
	//oauth 로그인 객체
	public PrincipalDetails(User_Entity user , Map<String, Object> attributes) {
		
		this.user = user;
		this.attributes = attributes;
		
	}


	//해당 유저의 권한을 리턴하는곳
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		
		collect.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
							
				return user.getRole();
			
			}
		});

		return collect;
	}

	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getEmail();
	}
	
	
	
	//계정 만료여부 (true가 아니오임)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정 잠김여부 (true가 아니오임)
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정의 패스워드가 오래 사용되었는지 여부 (true가 아니오임)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//계정이 활성화 되었는지 여부
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return attributes;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return (String) attributes.get("sub");
	}

}
