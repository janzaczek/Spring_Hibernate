package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Uczestnik")
@Data
public class Uczestnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Uczestnik")
    private long id;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_Event")
    private Event event;

    // połączenie zwrotne
    public void przypiszDoEventu(Event event){
        if(this.event != event){
            this.event = event;
            event.przypiszUczestnika(this);
        }
    }
}
