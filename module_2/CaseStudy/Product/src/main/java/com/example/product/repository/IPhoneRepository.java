package com.example.product.repository;

import com.example.product.model.Customer;
import com.example.product.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IPhoneRepository extends JpaRepository<Phone,Integer> {
}
