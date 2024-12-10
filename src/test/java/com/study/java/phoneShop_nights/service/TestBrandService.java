package com.study.java.phoneShop_nights.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.java.phoneShop_nights.Service.BrandService;
import com.study.java.phoneShop_nights.Service.Impl.BrandServiceImpl;
import com.study.java.phoneShop_nights.entity.Brand;
import com.study.java.phoneShop_nights.exception.ResourceNotFoundException;
import com.study.java.phoneShop_nights.repository.BrandRepository;


@ExtendWith(MockitoExtension.class)
public class TestBrandService {
    
    @Mock
    private BrandRepository brandRepository;

    private BrandService brandService;

    @BeforeEach
    public void setUp(){
        brandService = new BrandServiceImpl(brandRepository);
    }
/* 
    @Test
    public void TestCreate(){
        //given
        Brand brand = new Brand();
        brand.setName("Apple");
        brand.setId(1);

        //when
       when(brandRepository.save(any(Brand.class))).thenReturn(brand); 
        Brand brandReturn = brandService.create(new Brand());
        //then
        assertEquals(1, brandReturn.getId());
        assertEquals("Apple", brandReturn.getName()); 

    } */
    @Test
    public void TestCreate(){
        //given
        Brand brand = new Brand();
        brand.setName("Apple");
        brand.setId(1);
        //when
        brandService.create(brand);
        //then
        verify(brandRepository, times(1)).save(brand);
    }

    @Test
    public void TestGetByIdSuccess(){
        //given
        Brand brand = new Brand();
        brand.setId(1);
        brand.setName("Apple");
        //when
        when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
        Brand brandReturn = brandService.getById(1);

        //then
        assertEquals(1, brandReturn.getId());
        assertEquals("Apple", brandReturn.getName());

    }

    @Test
    public void TestGetByIdThrow(){
        //given

        //when
        when(brandRepository.findById(2)).thenReturn(Optional.empty());
    
        //then
        assertThatThrownBy(() -> brandService.getById(2))
                                    .isInstanceOf(ResourceNotFoundException.class)
                                    .hasMessage("Brand with id =  2 Not Found");
    }
}
