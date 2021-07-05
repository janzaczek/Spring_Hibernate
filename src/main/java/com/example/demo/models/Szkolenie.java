package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Szkolenie")
@Data
public class Szkolenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Szkolenie")
    private Long id;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "opis")
    private String opis;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
//    @JoinColumn(name = "odbyteSzkolenie")
    private List<OdbyteSzkolenie> odbyteSzkolenia = new ArrayList<>();

    // połączenie zwrotne
    public void przypiszOdbyteSzkolenia(OdbyteSzkolenie odbyteSzkolenie){
        if(!this.odbyteSzkolenia.contains(odbyteSzkolenie)){
            this.odbyteSzkolenia.add(odbyteSzkolenie);
            odbyteSzkolenie.przypiszSzkolenie(this);
        }
    }

    public void odbadzSzkolenie(OdbyteSzkolenie szkolenie) {
        getOdbyteSzkolenia().add(szkolenie);
        szkolenie.setSzkolenie(this);
    }

    public void anulujSzkolenie(OdbyteSzkolenie szkolenie) {
        getOdbyteSzkolenia().remove(szkolenie);
        szkolenie.setSzkolenie(null);
    }

}
