package com.example.demo.services;

import com.example.demo.enums.EventStan;
import com.example.demo.enums.EventStyl;
import com.example.demo.models.Event;
import com.example.demo.models.Klient;
import com.example.demo.models.Sala;
import com.example.demo.repository.KlientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.EventRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final KlientRepository klientRepository;
    private final Event event;

    @Autowired
    public EventService(EventRepository eventRepository, KlientRepository klientRepository){
        this.eventRepository = eventRepository;
        this.klientRepository = klientRepository;
        event = new Event();
    }

    public Optional<Event> znajdzEventPoKlientId(long idKlient) {
        return eventRepository.findById(idKlient);
    }

    public boolean sprawdzDate(Date date) {
        return eventRepository.findAll().stream().noneMatch(party -> party.getDate().equals(date));
    }

    public Event createEvent(){
//        return event;
        event.setKlient(klientRepository.getById(1L));
        return eventRepository.save(event);
    }

    public void przpiszStyl(EventStyl typ, Event event){
        event.setStyl(typ);
        saveEvent(event);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event findById(long id){
        return eventRepository.findById(id).get();
    }


    public void przypiszDate(Date data){
        event.setDate(data);
        planuj();
        eventRepository.save(event);
    }

    public void przypiszSale(Sala sala){
        event.przypiszSale(sala);
    }

    public List<Event> findAllEvents(){
        return eventRepository.findAll();
    }

    public boolean sprawdzLiczbeUczestnikow(long idEvent, int chNumber) {
        Optional<Event> event = eventRepository.findById(idEvent);
        if(event.isPresent()){
            int seatsRoom = event.get().getSala().getLiczbaMiejsc();
            return seatsRoom >= chNumber && seatsRoom >= event.get().getLiczbaUczestnikow();
        }
        return false;
    }

    public void odwolaj(long idEvent) {
        eventRepository
                .findById(idEvent)
                .ifPresent(party -> party.setStan(EventStan.anulowany));
    }

    public void planuj() {
        event.setStan(EventStan.zaplanowany);
    }

    public void usun(Event event){
        eventRepository.delete(event);
    }

    public void setStan(Event event, EventStan stan){
        event.setStan(stan);
    }

    public void zacznij(long idEvent) {
        eventRepository
                .findById(idEvent)
                .ifPresent(party -> party.setStan(EventStan.wTrakcie));
    }

    public void zaplac(long idEvent) {
        eventRepository
                .findById(idEvent)
                .ifPresent(party -> party.setStan(EventStan.zaplacony));
    }

    public void zakoncz(long idEvent) {
        eventRepository
                .findById(idEvent)
                .ifPresent(party -> party.setStan(EventStan.zakończony));
    }
}