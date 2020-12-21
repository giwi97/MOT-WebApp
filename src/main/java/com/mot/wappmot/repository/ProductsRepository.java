package com.mot.wappmot.repository;

import com.mot.wappmot.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

    Products findByitem(String item);

}
