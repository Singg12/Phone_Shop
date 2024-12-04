package com.study.java.phoneShop_nights.Service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.study.java.phoneShop_nights.entity.Brand;

@Service
public interface BrandService {
    Brand create(Brand brand);
    Brand getById(Integer id);
    Brand updateBrand(Integer id ,Brand brandUpdate);
    List<Brand> getBrandfilter(String name);
    //List<Brand> getBrands(Map<String, String> params);
    Page<Brand> getBrands(Map<String, String> params);
}
