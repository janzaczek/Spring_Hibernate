package com.example.demo.controllers;

import com.example.demo.services.UczestnikService;
import com.example.demo.models.Uczestnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
//@Slf4j
//@RequestMapping("uczestnicy")
//@CrossOrigin("*")
@Controller
public class UczestnikController {

    @Autowired
    private final UczestnikService uczestnikService;
//    Uczestnik uczestnik;

    public UczestnikController(UczestnikService uczestnikService){
        this.uczestnikService = uczestnikService;
    }

//    @PostMapping("/dodajUczestnikow")
//    public String dodajUczesntikow(Model model){
//        Uczestnik uczestnik = uczestnikService.create();
//        model.addAttribute("uczestnik", uczestnik);
//        model.addAttribute("lista",uczestnikService.uczestnicyEventu());
//        return "dodajUczestnikow";
//    }

//    @GetMapping(value = "")
//    public ResponseEntity<List<Uczestnik>> getUczestnicy() {
//        return new ResponseEntity<>((List<Uczestnik>)uczestnikRepository.findAll(), HttpStatus.OK);
//    }
//
//    @GetMapping(value = "{id}")
//    public ResponseEntity<Uczestnik> getById(@PathVariable("id") Long id) {
//        return new ResponseEntity<>(uczestnikRepository.findById(id).orElse(null), HttpStatus.OK);
//    }
}