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
}
