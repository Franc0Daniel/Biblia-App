package com.frank.bibliaapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frank.bibliaapi.model.Versiculo;
import com.frank.bibliaapi.services.VersiculoService;

@RestController
@RequestMapping("/api/v1/versiculos")
public class VersiculoController {

    private final VersiculoService versiculoService;

    public VersiculoController(VersiculoService versiculoService) {
        this.versiculoService = versiculoService;
    }

    @GetMapping("/{libro}/{capitulo}")
    public List<Versiculo> obtenerCapitulo(
            @PathVariable String libro,
            @PathVariable int capitulo) {
        return versiculoService.obtenerCapitulo(libro, capitulo);
    }

    @GetMapping("/{libro}/{capitulo}/{numero}")
    public List<Versiculo> obtenerVersiculo(
            @PathVariable String libro,
            @PathVariable int capitulo,
            @PathVariable int numero) {
        return versiculoService.obtenerVersiculo(libro, capitulo, numero);
    }
}