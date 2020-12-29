package com.mot.wappmot.controller;

import com.mot.wappmot.helper.ExcelHelper;
import com.mot.wappmot.model.Products;
import com.mot.wappmot.payload.ResponseMessage;
import com.mot.wappmot.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/upload")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")MultipartFile file){

        String message = "";

        if (ExcelHelper.hasExcelFormat(file)){

            try {

                productsService.saveExcel(file);

                message = "File uploaded successfully:" +file.getOriginalFilename();

                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

            }catch (Exception e){

                message = "File not uploaded "+file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));

            }

        }

        message = "Please upload an excel file";

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));

    }

    @GetMapping("/allprices")
    @CrossOrigin("http://localhost:4200")
    public List<Products> getAllPrices(){

        List<Products> products = new ArrayList<Products>();
        products = productsService.getAllProducts();
        return products;

    }

    @GetMapping("/searchCategory/{category}")
    @CrossOrigin("http://localhost:4200")
    public List<Products> getAllPricesByCategory(@PathVariable String category){

        List<Products> products = new ArrayList<Products>();
        products = productsService.getAllProductsByCategory(category);
        return products;

    }

    @DeleteMapping("/deletePrice/{id}")
    @CrossOrigin("http://localhost:4200")
    public String deletePricesByID(@PathVariable int id) {

        return productsService.deleteProductsByID(id);

    }

}
