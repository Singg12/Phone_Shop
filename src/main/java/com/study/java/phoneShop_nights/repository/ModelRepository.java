package com.study.java.phoneShop_nights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.java.phoneShop_nights.entity.Model;



@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {
    
}
