package com.frank.bibliaapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "versiculos")
public class Versiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libro;
    private int capitulo;
    private int numero;
    private String texto;

    protected Versiculo() {
    }

    public Versiculo(String libro, int capitulo, int numero, String texto) {
        this.libro = libro;
        this.capitulo = capitulo;
        this.numero = numero;
        this.texto = texto;
    }

    public Long getId() { return id; }
    public String getLibro() { return libro; }
    public int getCapitulo() { return capitulo; }
    public int getNumero() { return numero; }
    public String getTexto() { return texto; }
}