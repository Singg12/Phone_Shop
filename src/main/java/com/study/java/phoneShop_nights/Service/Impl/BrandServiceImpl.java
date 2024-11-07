package com.study.java.phoneShop_nights.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.study.java.phoneShop_nights.Service.BrandService;
import com.study.java.phoneShop_nights.entity.Brand;
import com.study.java.phoneShop_nights.exception.ApiException;
import com.study.java.phoneShop_nights.exception.ResourceNotFoundException;
import com.study.java.phoneShop_nights.repository.BrandRepository;

@Service
public class BrandServiceImpl  implements BrandService{

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand create(Brand brand) {

        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", id));
    }

    @Override
    public Brand updateBrand(Integer id, Brand brandUpdate) {
        Brand brand = getById(id);
        brand.setName(brandUpdate.getName());
        return brandRepository.save(brand);
    }
    

}
