package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Belt_Dto {

	private String company;

	private Long itemcount;
	
	private String itemname;
	
	private int price;
	
	private String color;

	private String category;
	
    private LocalDateTime createitemdate;
		
}
