package com.study.java.phoneShop_nights.Service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.study.java.phoneShop_nights.Service.BrandService;
import com.study.java.phoneShop_nights.Service.util.PageUtil;
import com.study.java.phoneShop_nights.entity.Brand;
import com.study.java.phoneShop_nights.exception.ApiException;
import com.study.java.phoneShop_nights.exception.ResourceNotFoundException;
import com.study.java.phoneShop_nights.repository.BrandRepository;
import com.study.java.phoneShop_nights.spec.BrandFilter;
import com.study.java.phoneShop_nights.spec.BrandSpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl  implements BrandService{

    @Autowired
    private final BrandRepository brandRepository;

    @Override
    public Brand create(Brand brand) {

        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Brand", id));
    }

    @Override
    public Brand updateBrand(Integer id, Brand brandUpdate) {
        Brand brand = getById(id);
        brand.setName(brandUpdate.getName());
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getBrandfilter(String name) {
        return brandRepository.findByNameLike("%"+name+ "%");
        }

    @Override
    public Page<Brand> getBrands(Map<String, String> params) {
        BrandFilter brandFilter = new BrandFilter();
        if(params.containsKey("name")){
            String name = params.get("name");
            brandFilter.setName(name);

        }
        if (params.containsKey("id")) {
            String id = params.get("id");
            brandFilter.setId(Integer.parseInt(id));
        }
        int pageLimit =PageUtil.DEFAULT_PAGE_LIMIT;
        if(params.containsKey(PageUtil.PAGE_LIMIT)){
            pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
        }
        int pageNumber =PageUtil.DEFAULT_PAGE_NUMBER;
        if(params.containsKey(PageUtil.PAGE_NUMBER)){
            pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
        }

        BrandSpec brandSpec = new BrandSpec(brandFilter);
        
        Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);

         Page<Brand> page = brandRepository.findAll(brandSpec,pageable);
         return page;
    }
        
    

}
