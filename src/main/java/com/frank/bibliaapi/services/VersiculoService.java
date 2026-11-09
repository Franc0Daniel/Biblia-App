package com.frank.bibliaapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frank.bibliaapi.model.Versiculo;

@Service
public class VersiculoService {

    // Datos de ejemplo. Más adelante vendrán de la base de datos.
    private final List<Versiculo> versiculos = List.of(
        new Versiculo("juan", 3, 16, "Texto de ejemplo del versículo 16"),
        new Versiculo("juan", 3, 17, "Texto de ejemplo del versículo 17"),
        new Versiculo("salmos", 23, 1, "Texto de ejemplo del versículo 1")
    );

    public List<Versiculo> obtenerCapitulo(String libro, int capitulo) {
        return versiculos.stream()
            .filter(v -> v.libro().equalsIgnoreCase(libro)
                      && v.capitulo() == capitulo)
            .toList();
    }

    public List<Versiculo> obtenerVersiculo(String libro, int capitulo, int numero) {
        return versiculos.stream()
            .filter(v -> v.libro().equalsIgnoreCase(libro)
                      && v.capitulo() == capitulo
                      && v.numero() == numero)
            .toList();
    }
}