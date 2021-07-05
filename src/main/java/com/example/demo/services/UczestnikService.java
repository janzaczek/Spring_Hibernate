package com.example.demo.services;

import com.example.demo.models.Event;
import com.example.demo.models.Uczestnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UczestnikRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UczestnikService {
    private final UczestnikRepository uczestnikRepository;
    Uczestnik uczestnik;
    List<Uczestnik> lista = new ArrayList<>();

    @Autowired
    public UczestnikService(UczestnikRepository uczestnikRepository){
        this.uczestnikRepository = uczestnikRepository;
    }

    public Uczestnik create(){
        uczestnik = new Uczestnik();
        uczestnikRepository.save(uczestnik);
        lista.add(uczestnik);
        return uczestnik;
    }

    public List<Uczestnik> uczestnicyEventu(){
        return lista;
    }
}