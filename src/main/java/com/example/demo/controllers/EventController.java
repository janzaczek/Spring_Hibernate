package com.example.demo.controllers;

import com.example.demo.models.Event;
import com.example.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.EventService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

//@RestController
//@RequestMapping("eventy")
//@CrossOrigin("*")
@Controller
public class EventController {

    @Autowired
    private final EventService eventService;
    Event event;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

//    @GetMapping(value = "/all", headers = "content-type=text/json")
//    @ResponseBody
//    public Event readJSON(Model model) {
//        Event event = eventService.findAllEvents(
//        model.addAttribute("eventy",eventService.findAllEvents());
//        return eventService;
//    }

//    @GetMapping(value = "/all")
//    public String getEventy(Model model) {
//        model.addAttribute("eventy",eventService.findAllEvents());
//        return "allEvents";
//    }
//
//    @GetMapping("/new")
//    public String main(Model model) {
//        event = eventService.createEvent();
//        model.addAttribute("event", event);
//        return "index";
//    }
//
//    @PostMapping("/save")
//    public String save(Event event, @DateTimeFormat(pattern = "yyyy-MM-dd")Date date) {
//        System.out.println(event.getDate().toString());
//        eventService.przypiszDate(date);
//        eventService.planuj(event);
//        return "save";
//    }
//    @PostMapping("")
//    public ResponseEntity<Event> insert(@RequestBody Event event) {
//        return new ResponseEntity<>(eventService.save(event), HttpStatus.CREATED);
//    }
}