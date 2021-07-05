package com.example.demo.models;

import com.example.demo.enums.PracownikStan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "Koordynator" )
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Koordynator extends Pracownik{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_Koordynator")
    private Long id;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "id_Event")
    private List<Event> event = new ArrayList<>();

//    @JsonIgnore
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    private Pracownik pracownik;

    @Transient
    @Column(name = "sredniaOcena")
    public double getAverageMark() {
        return this.event.stream().mapToInt(Event::getOcenaKoordynatora)
                .average()
                .orElse(0);
    }

    public Koordynator(Pracownik poprzednia, List<Event> event) {
        this.setImie(poprzednia.getImie());
        this.setNazwisko(poprzednia.getNazwisko());
        this.setPensja(poprzednia.getPensja());
        this.setDostepnosc(poprzednia.getDostepnosc());
        this.setStan(poprzednia.getStan());
        this.event = event;
        lista.remove(poprzednia);
    }


    // połączenie zwrotne
    public void przypiszDoEventu(Event event){
        if(!this.event.contains(event)){
            this.event.add(event);
            event.przypiszKoordynatora(this);
        }
    }

    @Override
    public void przypiszDodatekGraficzny(DodatekGraficzny dodatekGraficzny) {

    }
}
