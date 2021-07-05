package com.example.demo.services;

import com.example.demo.models.Event;
import com.example.demo.models.Sala;
import com.example.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.SalaRepository;

import java.util.*;

@Service
public class SalaService {
    @Autowired
    private final SalaRepository salaRepository;
    @Autowired
    private final EventRepository eventRepository;

    @Autowired
    public SalaService(SalaRepository salaRepository, EventRepository eventRepository){
        this.salaRepository = salaRepository;
        this.eventRepository = eventRepository;
    }

    public Sala findById(Long id){
        Sala sala = new Sala();
        if(salaRepository.findById(id).isPresent()){
            sala = salaRepository.findById(id).get();
        }
        return sala;
    }

    public Sala compare(Sala sala){
        return (Sala) salaRepository.findAll().stream().filter(e -> e.equals(sala));
    }

    public List<Sala> findAllFree(Date date){
        Set<Sala> saleRepository = new HashSet<>();
        eventRepository.findAll().stream().filter(e->!e.getDate().equals(date)).forEach(e -> saleRepository.add(e.getSala()));
        salaRepository.findAll().stream().filter(e->e.getEventy().isEmpty()).forEach(saleRepository::add);
        saleRepository.remove(null);
        return salaRepository.findAll();
    }

    public void przypiszEvent(Event event, Sala sala){
        event.setSala(sala);
        eventRepository.save(event);
        salaRepository.getById(sala.getId());
    }

    }