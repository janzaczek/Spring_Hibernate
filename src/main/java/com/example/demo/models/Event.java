package com.example.demo.models;

import com.example.demo.enums.EventStan;
import com.example.demo.enums.EventStyl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "Event")
@Getter
@Setter
@NoArgsConstructor
public class Event  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Event")
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Min(10)
    @Column(name = "liczbaUczestnikow")
    private Integer liczbaUczestnikow;

    @Min(1)
    @Max(10)
    @Column(name = "ocenaEventu")
    private Integer ocenaEventu;

    @Min(1)
    @Max(10)
    @Column(name = "ocenaKoordynatora")
    private Integer ocenaKoordynatora;

    @Max(200)
    @Column(name = "komentarz")
    private String komentarz;

    @Column(name = "cena")
    private int cena;

    @Column(name = "styl")
    @Enumerated(EnumType.STRING)
    private EventStyl styl;

    @Column(name = "stan")
    @Enumerated(EnumType.STRING)
    private EventStan stan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Sala")
    private Sala sala;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
//    @JoinColumn(name = "id_Uczestnik")
    private List<Uczestnik> uczestnik = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Klient")
    private Klient klient;

    @ManyToOne(fetch = FetchType.EAGER)
    private Koordynator koordynator;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
    private List<DodatekGraficzny> dodatekGraficzny = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Ochroniarz> ochroniarz = new ArrayList<>();

    public Event(Date dataRozpoczecia){
        this.date = dataRozpoczecia;
    }

    // połączenie zwrotne
    public void przypiszOchroniarza(Ochroniarz ochroniarz){
        if(!this.ochroniarz.contains(ochroniarz)){
            this.ochroniarz.add(ochroniarz);
            ochroniarz.przypiszDoEventu(this);
        }
    }

    // połączenie zwrotne
    public void przypiszDodatekGraficzny(DodatekGraficzny dodatekGraficzny){
        if(!this.dodatekGraficzny.contains(dodatekGraficzny)){
            this.dodatekGraficzny.add(dodatekGraficzny);
            dodatekGraficzny.przypiszDoEventu(this);
        }
    }

    // połączenie zwrotne
    public void przypiszKoordynatora(Koordynator koordynator){
        if(this.koordynator != koordynator){
            this.koordynator = koordynator;
            koordynator.przypiszDoEventu(this);
        }
    }
    // połączenie zwrotne
    public void przypiszKlienta(Klient klient){
        if(this.klient != klient){
            this.klient = klient;
            klient.przypiszDoEventu(this);
        }
    }

    // połączenie zwrotne
    public void przypiszUczestnika(Uczestnik uczestnik){
        if(!this.uczestnik.contains(uczestnik)){
            this.uczestnik.add(uczestnik);
            uczestnik.przypiszDoEventu(this);
        }
    }

    // połączenie zwrotne
    public void przypiszSale(Sala sala){
        if(this.sala == null || this.sala != sala){
            this.sala = sala;
//            sala.przypiszEvent(this);
        }
    }
}
