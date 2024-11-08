package com.study.java.phoneShop_nights.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.study.java.phoneShop_nights.dto.BrandDto;
import com.study.java.phoneShop_nights.entity.Brand;

@Mapper
public interface BrandMapper {
    
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand toBrand(BrandDto dto);

    BrandDto tBrandDto(Brand brand);

}
