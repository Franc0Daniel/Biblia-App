package com.frank.bibliaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frank.bibliaapi.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByUserId(String userId);
}