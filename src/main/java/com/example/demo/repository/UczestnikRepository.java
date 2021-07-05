package com.example.demo.repository;

import com.example.demo.models.Uczestnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UczestnikRepository extends JpaRepository<Uczestnik, Long> {
}

