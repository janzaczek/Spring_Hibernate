package com.example.demo;


import com.example.demo.enums.*;
import com.example.demo.models.*;
import com.example.demo.repository.*;
import com.example.demo.services.DodatekGraficznyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private KlientRepository klientRepository;
	@Autowired
	private SalaRepository salaRepository;
	@Autowired
	private DodatekGraficznyRepository dodatekGraficznyRepository;
	@Autowired
	private UczestnikRepository uczestnikRepository;
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private GrafikRepository grafikRepository;
	@Autowired
	private DodatekGraficznyService dodatekGraficznyService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		KlientIndywidualny k1 = new KlientIndywidualny();
		k1.setNumerKlienta(1);
		k1.setImie("Paweł");
		k1.setNazwisko("Dolny");
		k1.setDataUrodzenia(LocalDate.now());
		k1.setPlec(Plec.mezczyzna);
		klientRepository.save(k1);
		//setEvent

		KlientFirma k2 = new KlientFirma();
		k2.setNumerKlienta(2);
		k2.setAdres("Warszawa, dolna 11");
		k2.setNazwa("Google");
		k2.setNumerNIP(1234566);
		klientRepository.save(k2);
		//setEvent

		Sala s1 = new Sala();
		s1.setNazwa("Hala Orka");
		s1.setLiczbaMiejsc(40);
		salaRepository.save(s1);
		//setEvent

		Sala s2 = new Sala();
		s2.setNazwa("Opoka");
		s2.setLiczbaMiejsc(50);
		salaRepository.save(s2);

		Sala s3 = new Sala();
		s3.setNazwa("Kongresowa");
		s3.setLiczbaMiejsc(1000);
		salaRepository.save(s3);

		Sala s4 = new Sala();
		s4.setNazwa("Torwar");
		s4.setLiczbaMiejsc(15000);
		salaRepository.save(s4);

		Sala s5 = new Sala();
		s5.setNazwa("Zamek dla dzieci");
		s5.setLiczbaMiejsc(25);
		salaRepository.save(s5);

		DodatekGraficzny dg1 = new DodatekGraficzny();
		dg1.setCena(1000);
		dg1.setOpis(DodatekGraficznyOpis.calosciowy);
		dg1.setTyp(KursGraficznyStan.oprawa);
		dg1.setNazwa("XXX");
		dodatekGraficznyRepository.save(dg1);

		DodatekGraficzny dg2 = new DodatekGraficzny();
		dg2.setCena(7000);
		dg2.setOpis(DodatekGraficznyOpis.czesciowy);
		dg2.setTyp(KursGraficznyStan.animacja);
		dg2.setNazwa("Piraci");
		dodatekGraficznyRepository.save(dg2);

		DodatekGraficzny dg3 = new DodatekGraficzny();
		dg3.setCena(15000);
		dg3.setOpis(DodatekGraficznyOpis.calosciowy);
		dg3.setTyp(KursGraficznyStan.wizualizacja);
		dg3.setNazwa("James Bond");
		dodatekGraficznyRepository.save(dg3);

		DodatekGraficzny dg4 = new DodatekGraficzny();
		dg4.setCena(1000);
		dg4.setOpis(DodatekGraficznyOpis.czesciowy);
		dg4.setTyp(KursGraficznyStan.oprawa);
		dg4.setNazwa("Casino");
		dodatekGraficznyRepository.save(dg4);

		DodatekGraficzny dg5 = new DodatekGraficzny();
		dg5.setCena(7000);
		dg5.setOpis(DodatekGraficznyOpis.calosciowy);
		dg5.setTyp(KursGraficznyStan.animacja);
		dg5.setNazwa("Baśnie");
		dodatekGraficznyRepository.save(dg5);

		DodatekGraficzny dg6 = new DodatekGraficzny();
		dg6.setCena(15000);
		dg6.setOpis(DodatekGraficznyOpis.czesciowy);
		dg6.setTyp(KursGraficznyStan.wizualizacja);
		dg6.setNazwa("Alfa i Omega");
		dodatekGraficznyRepository.save(dg6);

		Event e = new Event();
		e.setDodatekGraficzny(Arrays.asList(dg1,dg2));
		e.setKlient(k1);
		e.setSala(s1);
		e.setDate(new Date());
		e.setStan(EventStan.zakończony);
		e.setStyl(EventStyl.formalny);
		e.setLiczbaUczestnikow(10);
		e.setOcenaEventu(9);
		e.setOcenaKoordynatora(8);
		e.setKomentarz("Swietny event!");
		e.setCena(2000);
		eventRepository.save(e);
		dodatekGraficznyService.przypiszDodatek(e,Arrays.asList(dg1,dg2));

		Event e2 = new Event();
		e2.setDodatekGraficzny(Arrays.asList(dg3,dg4));
		e2.setKlient(k2);
		e2.setSala(s2);
		e2.setStan(EventStan.zaplacony);
		e2.setStyl(EventStyl.smartCasual);
		e2.setLiczbaUczestnikow(83);
		e2.setKomentarz("Polecam te firme");
		e2.setOcenaEventu(7);
		e2.setOcenaKoordynatora(10);
		e2.setDate(new Date());
		e2.setCena(45000);
		eventRepository.save(e2);
		dodatekGraficznyService.przypiszDodatek(e2,Arrays.asList(dg3,dg4));

		Event e3 = new Event();
		e3.setDodatekGraficzny(Arrays.asList(dg5,dg6));
		e3.setKlient(k1);
		e3.setSala(s3);
		e3.setDate(new Date());
		e3.setStan(EventStan.anulowany);
		e3.setStyl(EventStyl.elegancki);
		e3.setLiczbaUczestnikow(120);
		e3.setCena(80000);
		eventRepository.save(e3);
		dodatekGraficznyService.przypiszDodatek(e3,Arrays.asList(dg5,dg6));

//		s1.przypiszEvent(e);

		Uczestnik u1 = new Uczestnik();
		u1.setImie("Jan1");
		u1.setNazwisko("Kowalski1");
		uczestnikRepository.save(u1);

		Uczestnik u2 = new Uczestnik();
		u2.setImie("Jan2");
		u2.setNazwisko("Kowalski2");
//		u2.setEvent(e);
		uczestnikRepository.save(u2);

		e.przypiszUczestnika(u1);
		e.przypiszUczestnika(u2);
		e.setUczestnik(Arrays.asList(u1,u2));
		eventRepository.save(e);

		Grafik grafik1 = new Grafik();
		grafik1.setDodatekGraficzny(Arrays.asList(dg1,dg2,dg3));
		grafik1.setLiczbaOprawGraficznych(3L);
		grafikRepository.save(grafik1);

		Grafik grafik2 = new Grafik();
		grafik2.setDodatekGraficzny(Arrays.asList(dg4,dg5,dg6));
		grafik2.setLiczbaOprawGraficznych(3L);
		grafikRepository.save(grafik2);
	}
}
