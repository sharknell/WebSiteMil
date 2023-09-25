package com.example.demo.uprovider;

import java.util.Map;

public class GoogleUserInfo implements OAuth2UserInfo {

	private Map<String,Object> attributes;
	
	public GoogleUserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String getProviderid() {
		return (String) attributes.get("sub");
	}

	@Override
	public String getEmail() {
		return (String) attributes.get("email");
	}

	@Override
	public String getName() {
		return (String) attributes.get("name");
	}

}
