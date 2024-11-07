package com.study.java.phoneShop_nights.Service.util;

import com.study.java.phoneShop_nights.dto.BrandDto;
import com.study.java.phoneShop_nights.entity.Brand;

public class Mapper {
    public static Brand toBrand(BrandDto dto){
        Brand brand = new Brand();
        //brand.setId(dto.getId());
        brand.setName(dto.getName());
        return brand;
    }
    public static BrandDto toBrandDto(Brand brand){
        BrandDto brandDto = new BrandDto();
        brandDto.setName(brand.getName());
        return brandDto;
    }
}
