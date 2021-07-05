package com.example.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import com.example.demo.models.Klient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.KlientRepository;

import java.util.List;

@Controller
public class KlientController {

//    @Autowired
    private final KlientRepository klientRepository;

    public KlientController(KlientRepository klientRepository){
        this.klientRepository = klientRepository;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Klient>> getKlienci() {
        return new ResponseEntity<>((List<Klient>)klientRepository.findAll(), HttpStatus.OK);
    }

//    @GetMapping(value = "{id}")
//    public ResponseEntity<Klient> getById(@PathVariable("id") Long id) {
//        return new ResponseEntity<>(klientRepository.findById(id).orElse(null), HttpStatus.OK);
//    }
}