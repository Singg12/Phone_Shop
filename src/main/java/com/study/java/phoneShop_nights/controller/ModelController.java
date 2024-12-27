package com.study.java.phoneShop_nights.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.java.phoneShop_nights.Service.ModelService;
import com.study.java.phoneShop_nights.entity.Model;
import com.study.java.phoneShop_nights.repository.BrandRepository;
import com.study.java.phoneShop_nights.repository.ModelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/model")
public class ModelController {

    private ModelService modeService;

    @PostMapping("/create")
    public ResponseEntity<?> CreateModel(@RequestBody Model model) {
      
        
        return null;
    }
    
}
