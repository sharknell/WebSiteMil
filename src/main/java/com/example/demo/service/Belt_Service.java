package com.example.demo.service;


import com.example.demo.entity.Belt;
import com.example.demo.repository.Belt_Repository;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Belt_Service {

	private final Belt_Repository repository;

	public List<Belt> Category_item_All(String item) {
			
		return repository.findByCategory(item);

	}

	public Optional<Belt> SelectONE(Long id){
		Optional<Belt> belt = repository.findById(id);
		//나중에 형 변환
		return belt;

	}
	//교수님이 개인프로젝트 10.4 까지 가져오래 1번 이유
	// 2번 이유 : 템플릿이 나와야지 내가 가능함
	





}
