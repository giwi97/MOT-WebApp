package com.mot.wappmot.repository;

import com.mot.wappmot.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

    //Products findByCategory(String category);
    List<Products> findByCategory(String category);
    @Query("SELECT DISTINCT category FROM Products")
    List<String> findDistinctByCategory();

}
