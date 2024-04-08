package com.example.product.service;

import com.example.product.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findCustomerByNameContaining(String name,Pageable pageable);
    void add(Customer cus);
    void delete(int id);
    void update(Customer cus);
    List<Customer> searchCus(String name);
    Optional<Customer> findById(int id);

    Page<Customer> searchList(Pageable pageable);


}
