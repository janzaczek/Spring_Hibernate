package com.example.demo.models;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OdbyteSzkolenie")
@Data
public class OdbyteSzkolenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_OdbyteSzkolenie")
    private Long id;

    @Column(name = "ocena")
    private int ocena;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data")
    private LocalDate data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Szkolenie")
    @NotNull
    private Szkolenie szkolenie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Pracownik")
    @NotNull
    private Pracownik pracownik;

    // połączenie zwrotne
    public void przypiszPracownika(Pracownik pracownik){
        if(this.pracownik != pracownik){
            this.pracownik = pracownik;
            pracownik.przypiszOdbyteSzkolenia(this);
        }
    }

    // połączenie zwrotne
    public void przypiszSzkolenie(Szkolenie szkolenie){
        if(this.szkolenie != szkolenie){
            this.szkolenie = szkolenie;
            szkolenie.przypiszOdbyteSzkolenia(this);
        }
    }
}
