package com.frank.bibliaapi.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frank.bibliaapi.dto.MessageResponseDto;
import com.frank.bibliaapi.dto.NotaRequestDto;
import com.frank.bibliaapi.model.Nota;
import com.frank.bibliaapi.repository.NotaRepository;
import com.frank.bibliaapi.services.NotaService;

@Service
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;

    public NotaServiceImpl(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @Override
    public List<Nota> obtenerNotasPorUsuario(String userId) {
        return notaRepository.findByUserId(userId);
    }

    @Override
    public MessageResponseDto agregarNota(String userId, NotaRequestDto request) {
        Nota nota = new Nota(userId, request.getVersiculoId(), request.getContenido());
        notaRepository.save(nota);
        return new MessageResponseDto("Nota guardada con éxito.");
    }

    @Override
    public MessageResponseDto actualizarNota(String userId, Long id, NotaRequestDto request) {
        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada"));
        
        if (!nota.getUserId().equals(userId)) {
            return new MessageResponseDto("No tienes permiso para modificar esta nota.");
        }

        nota.setContenido(request.getContenido());
        notaRepository.save(nota);
        return new MessageResponseDto("Nota actualizada con éxito.");
    }

    @Override
    public MessageResponseDto eliminarNota(String userId, Long id) {
        notaRepository.deleteById(id);
        return new MessageResponseDto("Nota eliminada correctamente.");
    }
}