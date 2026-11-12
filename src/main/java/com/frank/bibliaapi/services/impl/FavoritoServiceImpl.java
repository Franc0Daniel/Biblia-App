package com.frank.bibliaapi.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frank.bibliaapi.dto.FavoritoRequestDto;
import com.frank.bibliaapi.dto.MessageResponseDto;
import com.frank.bibliaapi.model.Favorito;
import com.frank.bibliaapi.repository.FavoritoRepository;
import com.frank.bibliaapi.services.FavoritoService;

@Service
public class FavoritoServiceImpl implements FavoritoService {

    private final FavoritoRepository favoritoRepository;

    public FavoritoServiceImpl(FavoritoRepository favoritoRepository) {
        this.favoritoRepository = favoritoRepository;
    }

    @Override
    public List<Favorito> obtenerFavoritosPorUsuario(String userId) {
        return favoritoRepository.findByUserId(userId);
    }

    @Override
    public MessageResponseDto agregarFavorito(String userId, FavoritoRequestDto request) {
        if (favoritoRepository.existsByUserIdAndVersiculoId(userId, request.getVersiculoId())) {
            return new MessageResponseDto("El versículo ya está en tus favoritos.");
        }
        
        Favorito favorito = new Favorito(userId, request.getVersiculoId());
        favoritoRepository.save(favorito);
        return new MessageResponseDto("Versículo agregado a favoritos con éxito.");
    }

    @Override
    public MessageResponseDto eliminarFavorito(String userId, Long id) {
        favoritoRepository.deleteById(id);
        return new MessageResponseDto("Favorito eliminado correctamente.");
    }
}