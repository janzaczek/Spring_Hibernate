package com.example.demo.controllers;

import com.example.demo.enums.DodatekGraficznyOpis;
import com.example.demo.enums.EventStyl;
import com.example.demo.enums.KursGraficznyStan;
import com.example.demo.models.DodatekGraficzny;
import com.example.demo.models.Sala;
import com.example.demo.models.Uczestnik;
import com.example.demo.models.Event;
import com.example.demo.services.DodatekGraficznyService;
import com.example.demo.services.EventService;
import com.example.demo.services.SalaService;
import com.example.demo.services.UczestnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
//@RestController
public class MainContoller {

    private final SalaService salaService;
    private final EventService eventService;
    private final UczestnikService uczestnikService;
    private final DodatekGraficznyService dodatekGraficznyService;

    Event event;

    @Autowired
    public MainContoller(SalaService salaService, EventService eventService, UczestnikService uczestnikService,
                         DodatekGraficznyService dodatekGraficznyService){
        this.salaService = salaService;
        this.eventService = eventService;
        this.uczestnikService = uczestnikService;
        this.dodatekGraficznyService = dodatekGraficznyService;
    }

    @GetMapping(value = "/all")
    public String getEventy(Model model) {
        model.addAttribute("eventy",eventService.findAllEvents());
        return "allEvents";
    }

    @GetMapping("/new")
    public String main(Model model) {
        event = eventService.createEvent();
        model.addAttribute("event", event);
        return "index";
    }

    @PostMapping("/save")
    public String saveEvent(Event event, @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        System.out.println(date);
        System.out.println(date.getClass().getName());
        eventService.przypiszDate(date);
        return "save";
    }

    @GetMapping("/resignation")
    public String resign() {
        eventService.usun(event);
        return "resignation";
    }

    //------------------sale--------------------

    @GetMapping("/allSale")
    public String getSale(Model model) {
        model.addAttribute("sale", salaService.findAllFree(new Date()));
        model.addAttribute("salaId",new Sala());
        return "allSale";
    }

@PostMapping("/saveSala")
public String saveSala(@ModelAttribute("salaId") Sala id, Model model) {
        Sala sala = salaService.findById(id.getId());
        salaService.przypiszEvent(event,sala);
//    dodatekGraficznyService.przypiszDodatek(event, dodatekGraficzny);
    model.addAttribute("id", id);
    System.out.println(sala);
    model.addAttribute("sala",sala);
    return "saveSala";
}

    //-----------------dodatki---------------------

    @GetMapping("/allDodatki")
    public String getDodatki(Model model) {
        model.addAttribute("dodatki", dodatekGraficznyService.findAllDodatki());
        return "allDodatki";
    }


    @PostMapping("/saveDodatek")
    public String saveDodatek(@RequestParam(value="tid") List<DodatekGraficzny> dodatekGraficzny, Model model) {
        dodatekGraficznyService.przypiszDodatek(event, dodatekGraficzny);
        model.addAttribute("dodatek", dodatekGraficzny);
        return "saveDodatek";
    }


    //------------------------uczestnik-------------------

    @PostMapping("/dodajUczestnikow")
    public String dodajUczesntikow(Model model){
        model.addAttribute("event", event);
        return "dodajUczestnikow";
    }

    @PostMapping("/saveUczestnikow")
    public String saveUczesntikow(@ModelAttribute Event event, Model model){
        Event alfa = eventService.findById(event.getId());
        alfa.setLiczbaUczestnikow(event.getLiczbaUczestnikow());
        eventService.saveEvent(alfa);
        model.addAttribute("event", event);
        return "saveUczestnikow";
    }

    //-----------------style---------------------

    @GetMapping("/allStyle")
    public String getStyle(Model model) {
        model.addAttribute("event", event);
        model.addAttribute("style", EventStyl.values());
        return "allStyle";
    }

    @PostMapping("/saveStyle")
    public String savestyle(@ModelAttribute Event event, Model model){
        Event alfa = eventService.findById(event.getId());
        alfa.setStyl(event.getStyl());
        eventService.saveEvent(alfa);
        model.addAttribute("event", alfa);
        return "saveStyle";
    }


    //---------------------final + zadanie + main----------------------------

    @GetMapping(value = "/main")
    public String main(){
        return "main";
    }
    @GetMapping("/final")
    public String finalEvent(Model model, @RequestParam(value = "id") int id){
        model.addAttribute("event", eventService.findById(id));
        return "final";
    }

    @GetMapping("/zadanie")
    public String zadanie(Model model){
        model.addAttribute("eventy", eventService.findAllEvents());
        model.addAttribute("event", new Event());
        return "zadanie";
    }

    @GetMapping("/zadanie2")
    public String zadanie2(Model model, @RequestParam(value = "id") int id){
        model.addAttribute("dodatki",eventService.findById(id).getDodatekGraficzny());
        return "zadanie2";
    }
}
