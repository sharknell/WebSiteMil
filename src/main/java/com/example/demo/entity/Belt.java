package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Belt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long itemcount;

	private String itemname;

	@ElementCollection
	@CollectionTable(name = "color_image_mapping", joinColumns = @JoinColumn(name = "itemcount"))
	@MapKeyColumn(name = "color")
	@Column(name = "image_path")
	private Map<String, String> colorImages;

	private String company;

	private String size;

	private String color;
	private String category;

	private int price;

	@Column(length = 1000)
	private String description;

	private LocalDateTime createitemdate;


	private String imglink; // 이미지 경로를 저장하는 필드
	private String imglink1; // 이미지 경로를 저장하는 필드
	private String imglink2; // 이미지 경로를 저장하는 필드
	private String imglink3; // 이미지 경로를 저장하는 필드

}
