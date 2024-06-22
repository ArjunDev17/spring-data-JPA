package com.codeneeti.spring_orm.repositories;

import com.codeneeti.spring_orm.entities.Product;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

//@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
    //Custom method
    //    customeMethod();
    //    List<Product> findByProductName(String productName);
    //    we can write same method using Optional<T>

    Optional<Product> findByProductName(String productName);

//    we can use sort also
//    Optional<Product> findByProductName(String productName, SpringDataWebProperties.Sort sort);

//    Product findByNameIs(String productName);

    List<Product> findByProductNameEquals(String productName);

//    List<Product> findByProductNameIsNot(String productName);
//
//    List<Product> findProductNameIsNull();

//    List<Product> findActiveTrue();  i was missing By

    List<Product> findByActiveTrue();

    List<Product> findByActiveFalse();

    List<Product> findByPid(String pid);

    List<Product> findByProductNameStartingWith(String prefix);

    List<Product> findByProductNameEndingWith(String suffix);

    List<Product> findByProductNameContaining(String infix);

    String PATTERN = "Samsung%";

    List<Product> findByProductNameLike(String PATTERN);

//    List<Product> findByPriceLessThan(double price);
//
//    List<Product> findByPriceGraterThan(double price);

    List<Product> findByPriceLessThan(double price);
    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByProductNameIn(Collection<String> strings);

    List<Product> findByProductNameAndPrice(String string, double price);

    List<Product> findByProductNameOrPrice(String string, double price);

    List<Product> findByProductNameOrderByProductNameAsc(String productName);

    //  Query------Method--------------------------------------------------------------------

    //select all products with query
    //JPQL :->DB independent

    @Query("SELECT p FROM Product p")
    List<Product> findAllProduct();

//    @Query("Select p from Product p where p.productName=`I phone`")
//    List<Product> getAllProduct();
    @Query("SELECT p FROM Product p")
    List<Product> getAllProduct();


    @Query("select p from Product p where p.pid=?1 and p.productName=?2")
    List<Product> getSingleProductByNameAndId();

    @Query("select p from Product p where p.pid= :pid and p.productName=:productName   ")
    List<Product>getSingleProductByParameter(@Param("pid")String pid,@Param("productName")String productName);

//    when we are going to update thaen along with querry we need to add @Modifying

// Native queries-------------------------
    //all key and field name should match to table database
    @Query(value = "select * from product where product_name=:product_name",nativeQuery = true)
    Product getProductByNativeQuery(@Param("product_name")String productName);


}
