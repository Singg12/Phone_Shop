package com.study.java.phoneShop_nights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.java.phoneShop_nights.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
    
}
