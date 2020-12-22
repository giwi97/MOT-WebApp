package com.mot.wappmot.repository;

import com.mot.wappmot.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

    //Products findByCategory(String category);
    List<Products> findByCategory(String category);

}
