package com.example.product.service.imp;

import com.example.product.model.Customer;
import com.example.product.repository.ICustomerRepository;
import com.example.product.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public Page<Customer> findCustomerByNameContaining(String name,Pageable pageable) {
        return iCustomerRepository.findCustomerByNameContaining(name,pageable);
    }

    @Override
    public void add(Customer cus) {
        iCustomerRepository.save(cus);
    }

    @Override
    public void delete(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public void update(Customer cus) {
        iCustomerRepository.save(cus);
    }

    @Override
    public List<Customer> searchCus(String name) {
        return iCustomerRepository.searchCustomerByName(name);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public Page<Customer> searchList(Pageable pageable) {
        return null;
    }
}
