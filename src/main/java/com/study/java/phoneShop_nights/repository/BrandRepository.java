package com.study.java.phoneShop_nights.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.study.java.phoneShop_nights.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>,JpaSpecificationExecutor<Brand>{
    List<Brand> findByNameLike(String name);
}

