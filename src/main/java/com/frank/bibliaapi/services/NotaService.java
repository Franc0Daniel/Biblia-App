package com.frank.bibliaapi.services;

import java.util.List;

import com.frank.bibliaapi.dto.MessageResponseDto;
import com.frank.bibliaapi.dto.NotaRequestDto;
import com.frank.bibliaapi.model.Nota;

public interface NotaService {
    List<Nota> obtenerNotasPorUsuario(String userId);
    MessageResponseDto agregarNota(String userId, NotaRequestDto request);
    MessageResponseDto actualizarNota(String userId, Long id, NotaRequestDto request);
    MessageResponseDto eliminarNota(String userId, Long id);
}