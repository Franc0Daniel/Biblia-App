package com.frank.bibliaapi.services;

import java.util.List;

import com.frank.bibliaapi.dto.FavoritoRequestDto;
import com.frank.bibliaapi.dto.MessageResponseDto;
import com.frank.bibliaapi.model.Favorito;

public interface FavoritoService {
    List<Favorito> obtenerFavoritosPorUsuario(String userId);
    MessageResponseDto agregarFavorito(String userId, FavoritoRequestDto request);
    MessageResponseDto eliminarFavorito(String userId, Long id);
}