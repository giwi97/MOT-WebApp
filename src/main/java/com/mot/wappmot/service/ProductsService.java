package com.mot.wappmot.service;

import com.mot.wappmot.model.Products;
import com.mot.wappmot.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public Products savePrices(Products products){

        return productsRepository.save(products);

    }
//    public Products fetchProductsByItem(String item){
//
//        return productsRepository.findByitem(item);
//
//    }
    public List<Products> getAllProducts() {

        return productsRepository.findAll();

    }

    public List<Products> getAllProductsByCategory(String category) {

        return productsRepository.findByCategory(category);

    }

    public String deleteProductsByID(int id){

        String result;

        try {

            productsRepository.deleteById(id);
            result = "Product successfully deleted";

        } catch (Exception e){

            result = "Error occured";

        }

        return result;

    }

}
