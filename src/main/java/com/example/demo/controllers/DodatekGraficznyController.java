package com.example.demo.controllers;

import com.example.demo.enums.DodatekGraficznyOpis;
import com.example.demo.enums.KursGraficznyStan;
import com.example.demo.models.DodatekGraficzny;
import com.example.demo.models.Event;
import com.example.demo.models.KursGraficzny;
import com.example.demo.services.DodatekGraficznyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.DodatekGraficznyRepository;

import java.util.Date;
import java.util.List;

//@RestController
//@RequestMapping("dodatkiGraficzne")
//@CrossOrigin("*")
@Controller
public class DodatekGraficznyController {

    @Autowired
    private final DodatekGraficznyService dodatekGraficznyService;
    DodatekGraficzny dodatek;

    public DodatekGraficznyController(DodatekGraficznyService dodatekGraficznyService){
        this.dodatekGraficznyService = dodatekGraficznyService;
    }

//    @GetMapping("/allDodatki")
//    public String getDodatki(Model model) {
//        model.addAttribute("dodatki", dodatekGraficznyService.findAllDodatki());
//        return "allDodatki";
//    }
//
////    @GetMapping("/wlasnyDodatek")
////    public String wlasnyDodatek(Model model) {
////        List<DodatekGraficzny> lista = dodatekGraficznyService.findAllDodatki();
////        model.addAttribute("dodatki", lista);
////        return "wlasnyDodatek";
////    }
//
//    @PostMapping("/saveDodatek")
//    public String saveDodatek(Event event, @RequestParam(value="tid")List<DodatekGraficzny> dodatekGraficzny, Model model) {
////        System.out.println(event.getDate().toString());
//        dodatekGraficznyService.przypiszDodatek(event, dodatekGraficzny);
//        model.addAttribute("dodatek", dodatekGraficzny);
//        return "saveDodatek";
//    }
//
//    @GetMapping("/createDodatek")
//    public String createDodatek(Model model) {
//        dodatek = dodatekGraficznyService.stworzDodatek();
//        model.addAttribute("dodatek",dodatek);
//        model.addAttribute("opis", dodatekGraficznyService.findAllOpis());
//        model.addAttribute("typ", dodatekGraficznyService.findAllTyp());
//        return "createDodatek";
//    }
//
//    @PostMapping("/dodatekWybierzOpis")
//    public String dodatekWybierzOpis(DodatekGraficznyOpis opis,
//                                    Model model) {
//        model.addAttribute("dodatek",dodatek);
//        model.addAttribute("opisy", opis);
//        dodatekGraficznyService.przypiszOpis(opis);
//        return "dodatekWybierzOpis";
//    }
//
//    @PostMapping("/dodatekWybierzTyp")
//    public String dodatekWybierzTyp(@RequestParam(value = "tid") KursGraficznyStan typ,
//                                    Model model) {
//        model.addAttribute("dodatek",dodatek);
//        model.addAttribute("typ", typ);
//        dodatekGraficznyService.przypiszTyp(typ);
//        return "dodatekWybierzTyp";
//    }
//
//    @PostMapping("/saveWlasnyDodatek")
//    public String saveWlasnyDodatek(DodatekGraficznyOpis opis,
//                                    KursGraficznyStan typ, Model model) {
//        dodatekGraficznyService.przypiszOpis(opis);
//        dodatekGraficznyService.przypiszTyp(typ);
//        model.addAttribute("dodatek",dodatek);
//        model.addAttribute("opisy", opis);
//        model.addAttribute("typy", typ);
//        return "saveWlasnyDodatek";
//    }
}