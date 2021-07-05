package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.example.demo.enums.KursGraficznyStan;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "KursGraficzny")
@Data
public class KursGraficzny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_KursGraficzny")
    private Long id;

    @Column(name = "typ")
    @Enumerated(EnumType.STRING)
    private KursGraficznyStan stan;

    @Column(unique = true, name = "numer")
    private long numer;

    @Column(name = "cena")
    private int cena;

    @Column(name = "opis")
    private String opis;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonManagedReference
    private Grafik grafik;

    // połączenie zwrotne
    public void przypiszDoGrafika(Grafik grafik){
        if(this.grafik != grafik){
            this.grafik = grafik;
            grafik.przypiszKursGraficzny(this);
        }
    }
}
