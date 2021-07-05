package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.KlientRepository;

@Service
public class KlientService {
    private final KlientRepository klientRepository;

    @Autowired
    public KlientService(KlientRepository klientRepository){
        this.klientRepository = klientRepository;
    }
}