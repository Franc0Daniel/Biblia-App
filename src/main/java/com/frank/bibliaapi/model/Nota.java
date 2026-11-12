package com.frank.bibliaapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "versiculo_id", nullable = false)
    private Long versiculoId;

    @Column(name = "contenido", nullable = false, columnDefinition = "TEXT")
    private String contenido;

    public Nota() {}

    public Nota(String userId, Long versiculoId, String contenido) {
        this.userId = userId;
        this.versiculoId = versiculoId;
        this.contenido = contenido;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Long getVersiculoId() { return versiculoId; }
    public void setVersiculoId(Long versiculoId) { this.versiculoId = versiculoId; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
}