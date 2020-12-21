package com.mot.wappmot.service;

import com.mot.wappmot.model.Products;
import com.mot.wappmot.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public Products savePrices(Products products){

        return productsRepository.save(products);

    }
    public Products fetchProductsByItem(String item){

        return productsRepository.findByitem(item);

    }
}
