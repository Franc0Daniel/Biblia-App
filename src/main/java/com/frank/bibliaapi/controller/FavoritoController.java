package com.frank.bibliaapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frank.bibliaapi.dto.FavoritoRequestDto;
import com.frank.bibliaapi.dto.MessageResponseDto;
import com.frank.bibliaapi.model.Favorito;
import com.frank.bibliaapi.services.FavoritoService;

@RestController
@RequestMapping("/api/v1/favoritos")
public class FavoritoController {

    private final FavoritoService favoritoService;

    public FavoritoController(FavoritoService favoritoService) {
        this.favoritoService = favoritoService;
    }

    // Listar los favoritos de un usuario (por ahora pasaremos el userId por cabecera o parámetro mientras integramos Cognito)
    @GetMapping
    public ResponseEntity<List<Favorito>> obtenerFavoritos(@RequestHeader(value = "X-User-Id", required = false) String userId) {
        if (userId == null) {
            userId = "usuario_prueba"; // Valor por defecto temporal
        }
        List<Favorito> favoritos = favoritoService.obtenerFavoritosPorUsuario(userId);
        return ResponseEntity.ok(favoritos);
    }
    // Agregar un versículo a favoritos
    @PostMapping
    public ResponseEntity<MessageResponseDto> agregarFavorito(
            @RequestHeader("X-User-Id") String userId,
            @RequestBody FavoritoRequestDto request) {
        MessageResponseDto respuesta = favoritoService.agregarFavorito(userId, request);
        return ResponseEntity.ok(respuesta);
    }

    // Eliminar un favorito por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> eliminarFavorito(
            @RequestHeader("X-User-Id") String userId,
            @PathVariable Long id) {
        MessageResponseDto respuesta = favoritoService.eliminarFavorito(userId, id);
        return ResponseEntity.ok(respuesta);
    }
}