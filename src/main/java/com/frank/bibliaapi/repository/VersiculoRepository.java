package com.frank.bibliaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frank.bibliaapi.model.Versiculo;

public interface VersiculoRepository extends JpaRepository<Versiculo, Long> {

    List<Versiculo> findByLibroIgnoreCaseAndCapituloOrderByNumero(String libro, int capitulo);

    List<Versiculo> findByLibroIgnoreCaseAndCapituloAndNumero(String libro, int capitulo, int numero);
}