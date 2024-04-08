package com.example.product.repository;

import com.example.product.model.Customer;
 import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(nativeQuery = true,value = "select * from customer where name LIKE %:name% ")
    List<Customer> searchCustomerByName(String name);

    Page<Customer> findCustomerByNameContaining(String name,Pageable pageable);
}
