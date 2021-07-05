package com.example.demo.controllers;

import com.example.demo.models.Event;
import com.example.demo.repository.EventRepository;
import com.example.demo.services.SalaService;
import lombok.extern.slf4j.Slf4j;
import com.example.demo.models.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.SalaRepository;

import java.util.Date;
import java.util.List;

//@RestController
//@Slf4j
//@RequestMapping("sale")
//@CrossOrigin("*")
@Controller
public class SalaController {

    @Autowired
    private final SalaService salaService;

    @Autowired
    private final EventRepository eventRepository;

//    Sala sala;

    public SalaController(SalaService salaService, EventRepository eventRepository){
        this.salaService = salaService;
        this.eventRepository = eventRepository;
    }

//    @GetMapping(value = "/sale")
//    public String getSale(Model model) {
//        model.addAttribute("sale", salaService.findAllFree(new Date()));
//        return "allSale";
//    }
//
//    @PostMapping("/saveSala")
//    public String save(Event event, @RequestParam(value="tid") Sala sala, Model model) {
//        System.out.println(event.getSala());
//        salaService.przypiszSale(event, sala);
//        model.addAttribute("sala",sala);
//        return "saveSala";
//    }

//    @GetMapping(value = "{id}")
//    public ResponseEntity<Sala> getById(@PathVariable("id") Long id) {
//        return new ResponseEntity<>(salaRepository.findById(id).orElse(null), HttpStatus.OK);
//    }
}