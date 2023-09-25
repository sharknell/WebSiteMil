package com.example.demo.uprovider;

import java.util.Map;

public class FacebookUserInfo implements OAuth2UserInfo{

	private Map<String,Object> attributes;
	
	public FacebookUserInfo(Map<String,Object> attributes) {
		this.attributes = attributes;	
	}
	
	@Override
	public String getProviderid() {
		return (String) attributes.get("id");
	}

	@Override
	public String getEmail() {
		
		return (String) attributes.get("email");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return (String) attributes.get("name");
	}

}
