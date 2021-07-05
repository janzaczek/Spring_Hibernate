package com.example.demo.models;

import com.example.demo.enums.DodatekGraficznyOpis;
import com.example.demo.enums.KursGraficznyStan;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DodatekGraficzny")
@Data
public class DodatekGraficzny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_DodatekGraficzny")
    private long id;

    @Column(name = "cena")
    private int cena;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "opis")
    @Enumerated(EnumType.STRING)
    private DodatekGraficznyOpis opis;

    @Column(name = "typ")
    @Enumerated(EnumType.STRING)
    private KursGraficznyStan typ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Grafik")
    private Pracownik grafik;

    // połączenie zwrotne
    public void przypiszDoEventu(Event event){
        if(this.event!=event){
            this.event=event;
            event.przypiszDodatekGraficzny(this);
        }
    }

    // połączenie zwrotne
    public void przypiszDoGrafika(Pracownik grafik){
        if(this.grafik != grafik){
            this.grafik = grafik;
            grafik.przypiszDodatekGraficzny(this);
        }
    }
}
