package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User_Entity_Permission_to_use {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer use_id;

	private String user_role;
	
	private String name;
	
	private Integer user_id;
	
	@CreatedDate
	private LocalDateTime datetime;
	 
}
