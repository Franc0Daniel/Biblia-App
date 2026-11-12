package com.frank.bibliaapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "favoritos")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId; // Aquí guardaremos el 'sub' o ID que nos mande Cognito

    @Column(name = "versiculo_id", nullable = false)
    private Long versiculoId;

    public Favorito() {}

    public Favorito(String userId, Long versiculoId) {
        this.userId = userId;
        this.versiculoId = versiculoId;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Long getVersiculoId() { return versiculoId; }
    public void setVersiculoId(Long versiculoId) { this.versiculoId = versiculoId; }
}