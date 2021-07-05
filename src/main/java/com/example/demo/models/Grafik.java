package com.example.demo.models;

import com.example.demo.enums.PracownikStan;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table( name = "Grafik" )
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Grafik extends Pracownik{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_Grafik")
    private Long id;

    @Column(name = "liczbaOprawGraficznych")
    private Long liczbaOprawGraficznych;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
//    @JoinColumn(name = "kursyGraficzne")
    private List<KursGraficzny> kursGraficzny = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
//    @JoinColumn(name = "dodatkiGraficzne")
    private List<DodatekGraficzny> dodatekGraficzny = new ArrayList<>();

    public Grafik(Pracownik poprzednia, Long liczbaOprawGraficznych) {
        this.setImie(poprzednia.getImie());
        this.setNazwisko(poprzednia.getNazwisko());
        this.setPensja(poprzednia.getPensja());
        this.setDostepnosc(poprzednia.getDostepnosc());
        this.setStan(poprzednia.getStan());
        this.liczbaOprawGraficznych = liczbaOprawGraficznych;
        lista.remove(poprzednia);
    }

    // połączenie zwrotne
    public void przypiszDodatekGraficzny(DodatekGraficzny dodatekGraficzny){
        if(!this.dodatekGraficzny.contains(dodatekGraficzny)){
            this.dodatekGraficzny.add(dodatekGraficzny);
            dodatekGraficzny.przypiszDoGrafika(this);
        }
    }

    // połączenie zwrotne
    public void przypiszKursGraficzny(KursGraficzny kursGraficzny){
        if(!this.kursGraficzny.contains(kursGraficzny)){
            this.kursGraficzny.add(kursGraficzny);
            kursGraficzny.przypiszDoGrafika(this);
        }
    }

}
