package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class KlientFirma extends Klient{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_KlientFirma")
    private long id;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "adres")
    private String adres;

    @Column(unique = true, name = "numerNIP")
    private long numerNIP;

}
