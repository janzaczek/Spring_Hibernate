package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Sala")
@Getter
@Setter
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Sala")
    private long id;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "liczbaMiejsc")
    private int liczbaMiejsc;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
//    @JoinColumn(name = "id_Event")
    private List<Event> eventy = new ArrayList<>();

    // połączenie zwrotne
    public void przypiszEvent(Event event){
        if(!this.eventy.contains(event)){
            this.eventy.add(event);
            event.przypiszSale(this);
        }
    }
}
