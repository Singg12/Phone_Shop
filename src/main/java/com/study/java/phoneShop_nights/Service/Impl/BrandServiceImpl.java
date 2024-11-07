package com.study.java.phoneShop_nights.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.java.phoneShop_nights.Service.BrandService;
import com.study.java.phoneShop_nights.entity.Brand;
import com.study.java.phoneShop_nights.repository.BrandRepository;

@Service
public class BrandServiceImpl  implements BrandService{

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand create(Brand brand) {

        return brandRepository.save(brand);
    }
    

}
