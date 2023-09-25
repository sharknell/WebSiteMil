package com.example.demo.oauth;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.demo.auth.PrincipalDetails;
import com.example.demo.entity.User_Entity;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.SecurityConfig;
import com.example.demo.uprovider.FacebookUserInfo;
import com.example.demo.uprovider.GoogleUserInfo;
import com.example.demo.uprovider.NaverUserInfo;
import com.example.demo.uprovider.OAuth2UserInfo;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		OAuth2User oauth2user = super.loadUser(userRequest);
		
		OAuth2UserInfo auth2UserInfo = null;
		
		if(userRequest.getClientRegistration().getRegistrationId().equals("google")) {			
			auth2UserInfo = new GoogleUserInfo(oauth2user.getAttributes());
		}
		else if(userRequest.getClientRegistration().getRegistrationId().equals("facebook")) {
			auth2UserInfo = new FacebookUserInfo(oauth2user.getAttributes());
		}
		else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
			auth2UserInfo = new NaverUserInfo((Map)oauth2user.getAttributes().get("response"));
		}
		else {};
		
		
		String provider 		= userRequest.getClientRegistration().getRegistrationId();
		String providerid 		= auth2UserInfo.getProviderid();
		String username 		= auth2UserInfo.getName();
		String email 			= auth2UserInfo.getEmail();
		String password 		= SecurityConfig.incoding_password().encode("1234");
		String role 			= "USER";
		User_Entity user		= userRepository.findByEmailAndProvider(email, provider);
		User_Entity new_user 	= new User_Entity();


		if(user == null) {
			
			new_user.setUsername(username);
			new_user.setEmail(email);
			new_user.setPassword(password);
			new_user.setDatetime(LocalDateTime.now());
			new_user.setRole(role);
			new_user.setProvider(provider);
			new_user.setProviderid(providerid);
			
			userRepository.save(new_user);
			
			return new PrincipalDetails(new_user, oauth2user.getAttributes());
			
		}
		else {
			
			return new PrincipalDetails(user, oauth2user.getAttributes());
				
		}
		
	}
	
}
