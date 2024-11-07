package com.study.java.phoneShop_nights.Service;

import org.springframework.stereotype.Service;

import com.study.java.phoneShop_nights.entity.Brand;

@Service
public interface BrandService {
    Brand create(Brand brand);

}
