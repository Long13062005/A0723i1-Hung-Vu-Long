package com.example.product.service;

import com.example.product.model.Customer;
import com.example.product.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPhoneService {
   List<Phone> findAll();
}
