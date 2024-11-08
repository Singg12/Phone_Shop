package com.study.java.phoneShop_nights.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.study.java.phoneShop_nights.Service.BrandService;
import com.study.java.phoneShop_nights.dto.BrandDto;
import com.study.java.phoneShop_nights.entity.Brand;
import com.study.java.phoneShop_nights.mapper.BrandMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody BrandDto brandDto){
        Brand brand = BrandMapper.INSTANCE.toBrand(brandDto);
        brand = brandService.create(brand);
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrand(brandDto));
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer brandId) {
        Brand brand = brandService.getById(brandId);
        return ResponseEntity.ok(BrandMapper.INSTANCE.tBrandDto(brand));
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateProductById(@PathVariable("id") Integer brandId, @RequestBody BrandDto brandDto) {
        Brand brand = BrandMapper.INSTANCE.toBrand(brandDto);
        Brand brandUpdate = brandService.updateBrand(brandId, brand);
        return ResponseEntity.ok(brandUpdate);
    }
    @GetMapping
    public ResponseEntity<?> getAllBrands() {

        List<BrandDto> list= brandService.getBrands()
                        .stream()
                        .map(brand -> BrandMapper.INSTANCE.tBrandDto(brand))
                        .collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }
    @GetMapping("/filter")
    public ResponseEntity<?> getBrandFilter(@RequestParam("name") String name) {
        List<BrandDto> list= brandService.getBrandfilter(name)
                        .stream()
                        .map(brand -> BrandMapper.INSTANCE.tBrandDto(brand))
                        .collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }
     
    
    
}
