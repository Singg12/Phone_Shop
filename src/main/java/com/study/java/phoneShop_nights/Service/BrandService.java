package com.study.java.phoneShop_nights.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.java.phoneShop_nights.entity.Brand;

@Service
public interface BrandService {
    Brand create(Brand brand);
    Brand getById(Integer id);
    Brand updateBrand(Integer id ,Brand brandUpdate);
    List<Brand> getBrands();
    List<Brand> getBrandfilter(String name);
}
