package com.mot.wappmot.controller;

import com.mot.wappmot.model.Products;
import com.mot.wappmot.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping("/addprice")
    @CrossOrigin("http://localhost:4200")
    public Products addPrices(@RequestBody Products products) throws Exception {

        Products prodObj = null;
        prodObj = productsService.savePrices(products);

        return prodObj;

    }

    @GetMapping("/allprices")
    @CrossOrigin("http://localhost:4200")
    public List<Products> getAllPrices(){

        List<Products> products = new ArrayList<Products>();
        return products;

    }

}
