package com.example.demo.repository;

import com.example.demo.entity.Belt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Belt_Repository extends JpaRepository<Belt, Long>{
    public List<Belt> findByCategory(String item);
}
