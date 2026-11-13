package com.frank.bibliaapi.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frank.bibliaapi.dto.MessageResponseDto;
import com.frank.bibliaapi.dto.NotaRequestDto;
import com.frank.bibliaapi.exception.ResourceNotFoundException;
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
        // Validación con nuestra excepción 404 personalizada si no existe
        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La nota solicitada no existe o fue eliminada."));

        // Validación de seguridad por si el usuario no es dueño de la nota
        if (!nota.getUserId().equals(userId)) {
            throw new ResourceNotFoundException("No tienes permiso para modificar esta nota."); 
            // O bien puedes crear una excepción UnauthorizedException si prefieres un 403
        }

        nota.setContenido(request.getContenido());
        notaRepository.save(nota);
        return new MessageResponseDto("Nota actualizada con éxito.");
    }

    @Override
    public MessageResponseDto eliminarNota(String userId, Long id) {
        // Validamos que exista antes de borrar para disparar el 404 si ya no está
        if (!notaRepository.existsById(id)) {
            throw new ResourceNotFoundException("La nota solicitada no existe o fue eliminada.");
        }

        notaRepository.deleteById(id);
        return new MessageResponseDto("Nota eliminada correctamente.");
    }
}