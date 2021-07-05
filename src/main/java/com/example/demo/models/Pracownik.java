package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.example.demo.enums.PracownikStan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pracownik")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name="prac_seq", initialValue=1, allocationSize=1)
@Data
public abstract class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_Pracownik")
    private Long id;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "pensja")
    private int pensja;

    @Column(name = "dostepnosc")
    private int dostepnosc;

    @Column(name = "typ")
    @Enumerated(EnumType.STRING)
    private PracownikStan stan;

    @Transient
    @Column(name = "bonus")
    private Integer bonus;

    static List<Pracownik> lista = new ArrayList<>();

    @JsonBackReference
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<OdbyteSzkolenie> odbyteSzkolenie = new ArrayList<>();

    // połączenie zwrotne
    public void przypiszOdbyteSzkolenia(OdbyteSzkolenie odbyteSzkolenie){
        if(!this.odbyteSzkolenie.contains(odbyteSzkolenie)){
            this.odbyteSzkolenie.add(odbyteSzkolenie);
            odbyteSzkolenie.przypiszPracownika(this);
        }
    }

    public String pokazWyplate(){
        StringBuilder sb = new StringBuilder();
        if(getBonus()!= null) {
            int suma = pensja + getBonus();
            return sb.append(suma).toString();
        }
        else
            return sb.append(pensja).toString();
    }

    public abstract void przypiszDodatekGraficzny(DodatekGraficzny dodatekGraficzny);
}
