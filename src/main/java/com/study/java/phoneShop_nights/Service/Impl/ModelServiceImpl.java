package com.study.java.phoneShop_nights.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.java.phoneShop_nights.Service.ModelService;
import com.study.java.phoneShop_nights.entity.Model;
import com.study.java.phoneShop_nights.repository.ModelRepository;

@Service
public class ModelServiceImpl implements ModelService  {
    
    @Autowired
    private ModelRepository modelRepository;
    @Override
    public Model create(Model model) {
        return modelRepository.save(model);
    }
    
}
