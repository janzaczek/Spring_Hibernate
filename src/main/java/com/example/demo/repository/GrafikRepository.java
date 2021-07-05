package com.example.demo.repository;

import com.example.demo.models.Grafik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrafikRepository extends JpaRepository<Grafik,Long> {
}
