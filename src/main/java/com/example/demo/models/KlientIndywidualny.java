package com.example.demo.models;

import com.example.demo.enums.Plec;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class KlientIndywidualny extends Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_KlientIndywidualny")
    private long id;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "plec")
    @Enumerated(EnumType.STRING)
    private Plec plec;

    @Column(name = "dataUrodzenia")
    private LocalDate dataUrodzenia;

}
