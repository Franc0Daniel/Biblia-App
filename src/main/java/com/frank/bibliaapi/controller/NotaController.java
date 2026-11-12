package com.frank.bibliaapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frank.bibliaapi.dto.MessageResponseDto;
import com.frank.bibliaapi.dto.NotaRequestDto;
import com.frank.bibliaapi.model.Nota;
import com.frank.bibliaapi.services.NotaService;

@RestController
@RequestMapping("/api/v1/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping
    public ResponseEntity<List<Nota>> obtenerNotas(@RequestHeader(value = "X-User-Id", required = false) String userId) {
        if (userId == null) {
            userId = "usuario_prueba"; // Valor por defecto para pruebas
        }
        List<Nota> notas = notaService.obtenerNotasPorUsuario(userId);
        return ResponseEntity.ok(notas);
    }
    @PostMapping
    public ResponseEntity<MessageResponseDto> agregarNota(
            @RequestHeader("X-User-Id") String userId,
            @RequestBody NotaRequestDto request) {
        MessageResponseDto respuesta = notaService.agregarNota(userId, request);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponseDto> actualizarNota(
            @RequestHeader("X-User-Id") String userId,
            @PathVariable Long id,
            @RequestBody NotaRequestDto request) {
        MessageResponseDto respuesta = notaService.actualizarNota(userId, id, request);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> eliminarNota(
            @RequestHeader("X-User-Id") String userId,
            @PathVariable Long id) {
        MessageResponseDto respuesta = notaService.eliminarNota(userId, id);
        return ResponseEntity.ok(respuesta);
    }
}