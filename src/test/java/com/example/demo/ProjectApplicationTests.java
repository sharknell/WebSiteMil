package com.example.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

import com.example.demo.entity.Belt;
import com.example.demo.repository.Belt_Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.User_Entity;
import com.example.demo.repository.UserRepository;

@SpringBootTest
class ProjectApplicationTests {

	
	@Autowired
	public Belt_Repository repository;

	@Test
	void contextLoads() {

		Belt entity = new Belt().builder()
				.category("hard")
				.company("TYR")
				.itemname("LEVEL 3+ HA3/STC PLATE")
				.colorImages(new HashMap<>()) // 이미지 경로를 저장하는 빈 Map 생성
				.size("xs "+ "," + "s" +","+"M" + "," + "L" + "," + "XL" )
				.price(1000)
				.imglink("31") // 이미지 경로를 저장
				.color("BLACK")
				.imglink1("1")
				.build();

		//entity.getColorImages().put("MUL", "/optione/mul.png"); // 컬러에 해당하는 이미지 경로 저장
		entity.getColorImages().put("BLACK", "/optione/black.png");
		//entity.getColorImages().put("TAN", "/optione/tan.png");
		//entity.getColorImages().put("RG", "/optione/rg.png");

		repository.save(entity);
	}
}
