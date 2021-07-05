package com.example.demo.services;

import com.example.demo.enums.DodatekGraficznyOpis;
import com.example.demo.enums.KursGraficznyStan;
import com.example.demo.models.DodatekGraficzny;
import com.example.demo.models.Event;
import com.example.demo.models.KursGraficzny;
import com.example.demo.models.Sala;
import com.example.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.DodatekGraficznyRepository;

import java.util.*;

@Service
public class DodatekGraficznyService {
    private final DodatekGraficznyRepository dodatekGraficznyRepository;
    private final DodatekGraficzny dodatek;
    private final EventRepository eventRepository;

    @Autowired
    public DodatekGraficznyService(DodatekGraficznyRepository dodatekGraficznyRepository, EventRepository eventRepository){
        this.dodatekGraficznyRepository = dodatekGraficznyRepository;
        this.eventRepository = eventRepository;
        dodatek = new DodatekGraficzny();
    }

//    public void stworzNowyDodatek(DodatekGraficznyOpis opis, KursGraficznyStan typ){
//        DodatekGraficzny d1 = new DodatekGraficzny();
//    }

    public List<DodatekGraficzny> findAllDodatki(){
        return dodatekGraficznyRepository.findAll();
    }

    public void przypiszDodatek(Event event, List<DodatekGraficzny> dodatekGraficzny){
        dodatekGraficzny.forEach(dodatekGraficzny1 -> dodatekGraficzny1.setEvent(event));
        dodatekGraficzny.forEach(dodatekGraficznyRepository::save);
    }

    public DodatekGraficzny stworzDodatek(){
        dodatekGraficznyRepository.save(dodatek);
        return dodatek;
    }

    public void przypiszOpis(DodatekGraficznyOpis opis){
        dodatek.setOpis(opis);
    }

    public void przypiszTyp(KursGraficznyStan typ){
        dodatek.setTyp(typ);
    }
//    public void stworzDodatek2(DodatekGraficznyOpis opis){
//        DodatekGraficzny d = new DodatekGraficzny();
////        d.setTyp(typ);
//        d.setOpis(opis);
//        dodatekGraficznyRepository.save(d);


    public List<DodatekGraficznyOpis> findAllOpis(){
        return new ArrayList<DodatekGraficznyOpis>(Arrays.asList(DodatekGraficznyOpis.values()));
    }

    public List<KursGraficznyStan> findAllTyp(){
        return new ArrayList<KursGraficznyStan>(Arrays.asList(KursGraficznyStan.values()));
    }
}
