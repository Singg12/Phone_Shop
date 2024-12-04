package com.study.java.phoneShop_nights.spec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import com.study.java.phoneShop_nights.entity.Brand;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;


@Data
public class BrandSpec implements Specification<Brand> {
    private final BrandFilter brandFilter;

    List<Predicate> predicates = new ArrayList<>();

    @Override
    @Nullable
    public Predicate toPredicate(Root<Brand> brand, @Nullable CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(brandFilter.getName() != null){
            Predicate name = cb.like(cb.upper(brand.get("name")), "%" +brandFilter.getName().toUpperCase()+ "%");
             
            predicates.add(name);

            // Predicate name = brand.get("name").in(brandFilter.getName());
            // predicates.add(name);
        }
        if(brandFilter.getId() != null){
            Predicate id = brand.get("id").in(brandFilter.getId());
            predicates.add(id);
        }
            

        return cb.and(predicates.toArray(Predicate[]::new));
    }
    
}
