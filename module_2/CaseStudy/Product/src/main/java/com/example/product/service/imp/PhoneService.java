package com.example.product.service.imp;

import com.example.product.model.Phone;
import com.example.product.repository.IPhoneRepository;
import com.example.product.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PhoneService implements IPhoneService {
    @Autowired
    IPhoneRepository iPhoneRepository;
    @Override
    public List<Phone> findAll(   ) {
        return iPhoneRepository.findAll( );
    }
}
