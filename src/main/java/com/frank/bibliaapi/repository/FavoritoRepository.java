package com.frank.bibliaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frank.bibliaapi.model.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
    
    // Para buscar todos los favoritos de un usuario específico usando su ID de Cognito
    List<Favorito> findByUserId(String userId);
    
    // Para verificar si un usuario ya guardó un versículo específico (evitar duplicados)
    boolean existsByUserIdAndVersiculoId(String userId, Long versiculoId);
}