package com.example.demo.repository;

import com.example.demo.models.DodatekGraficzny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DodatekGraficznyRepository extends JpaRepository<DodatekGraficzny, Long> {
}

