package com.frank.bibliaapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frank.bibliaapi.model.Versiculo;
import com.frank.bibliaapi.repository.VersiculoRepository;

@Service
public class VersiculoService {

    private final VersiculoRepository versiculoRepository;

    public VersiculoService(VersiculoRepository versiculoRepository) {
        this.versiculoRepository = versiculoRepository;
    }

    public List<Versiculo> obtenerCapitulo(String libro, int capitulo) {
        return versiculoRepository.findByLibroIgnoreCaseAndCapituloOrderByNumero(libro, capitulo);
    }

    public List<Versiculo> obtenerVersiculo(String libro, int capitulo, int numero) {
        return versiculoRepository.findByLibroIgnoreCaseAndCapituloAndNumero(libro, capitulo, numero);
    }
}