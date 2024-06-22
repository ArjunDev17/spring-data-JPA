package com.codeneeti.spring_orm.repositories;

import com.codeneeti.spring_orm.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository <Product,String>{
}
