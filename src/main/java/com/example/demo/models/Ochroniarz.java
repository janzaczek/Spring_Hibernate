package com.example.demo.models;

import com.example.demo.enums.PracownikStan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "Ochroniarz" )
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Ochroniarz extends Pracownik{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_Ochroniarz")
    private Long id;

    @Column(name = "liczbaLatPracy")
    private int liczbaLatPracy;

    @ManyToOne(fetch = FetchType.EAGER)
    private Event event;

    public Ochroniarz(Pracownik poprzednia, int liczbaLatPracy) {
        this.setImie(poprzednia.getImie());
        this.setNazwisko(poprzednia.getNazwisko());
        this.setPensja(poprzednia.getPensja());
        this.setDostepnosc(poprzednia.getDostepnosc());
        this.setStan(poprzednia.getStan());
        this.liczbaLatPracy = liczbaLatPracy;
        lista.remove(poprzednia);
    }
    // połączenie zwrotne
    public void przypiszDoEventu(Event event){
        if(this.event != event){
            this.event = event;
            event.przypiszOchroniarza(this);
        }
    }

    @Override
    public void przypiszDodatekGraficzny(DodatekGraficzny dodatekGraficzny) {

    }
}
