package com.example.demo.models;

import com.example.demo.enums.KursGraficznyStan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "Klient")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name="klient_seq", initialValue=1, allocationSize=1)
@Data
public abstract class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_Klient")
    private long id;

    @Column(unique = true, name = "numerKlienta")
    private int numerKlienta;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
//    @JoinColumn(name = "id_Event")
    private List<Event> event = new ArrayList<>();

    // połączenie zwrotne
    public void przypiszDoEventu(Event event){
        if(!this.event.contains(event)){
            this.event.add(event);
            event.przypiszKlienta(this);
        }
    }

    public void ocenEvent(Event event, int ocena){
        if(this.event.contains(event))
            this.event.stream().filter(e -> e == event).forEach(e -> e.setOcenaEventu(ocena));
        else
            System.out.println("Nie mogę tego zrobić");
    }

}
