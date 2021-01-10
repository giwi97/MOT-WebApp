package com.mot.wappmot.service;

import com.mot.wappmot.helper.ExcelHelper;
import com.mot.wappmot.model.Products;
import com.mot.wappmot.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
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

    public void saveExcel(MultipartFile file){

        try {

            List<Products> products = ExcelHelper.excelToProducts(file.getInputStream());
            productsRepository.saveAll(products);

            System.out.println("Wirrrrrrrrrr");
        }catch (IOException e){

            throw new RuntimeException("Unable to store data:" +e.getMessage());

        }

    }

    public List<Products> getAllProducts() {

        return productsRepository.findAllByDesc();

    }

    public List<Products> getAllProductsByCategory(String category) {

        return productsRepository.findByCategory(category);

    }

    public List<String> getAllCategories() {
        return productsRepository.findDistinctByCategory();
    }

    public Double getAveragePrice(Date date, String category) {

        return productsRepository.findAveragePrice(date, category);

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
