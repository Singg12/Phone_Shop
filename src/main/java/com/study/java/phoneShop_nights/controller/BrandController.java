package com.study.java.phoneShop_nights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.study.java.phoneShop_nights.Service.BrandService;
import com.study.java.phoneShop_nights.Service.util.Mapper;
import com.study.java.phoneShop_nights.dto.BrandDto;
import com.study.java.phoneShop_nights.entity.Brand;

@RestController
@RequestMapping("brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody BrandDto brandDto){
        Brand brand = Mapper.toBrand(brandDto);
        brand = brandService.create(brand);
        return ResponseEntity.ok(Mapper.toBrandDto(brand));
    }
}
