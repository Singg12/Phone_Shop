package com.study.java.phoneShop_nights.Service;

import org.springframework.stereotype.Service;

import com.study.java.phoneShop_nights.entity.Model;

@Service
public interface ModelService {
    Model create(Model model);
}
