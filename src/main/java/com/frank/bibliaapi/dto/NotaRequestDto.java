package com.frank.bibliaapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NotaRequestDto {

    @NotNull(message = "El ID del versículo no puede ser nulo")
    private Long versiculoId;

    @NotBlank(message = "El contenido no puede estar vacío")
    private String contenido;

    public NotaRequestDto() {}

    public Long getVersiculoId() {
        return versiculoId;
    }

    public void setVersiculoId(Long versiculoId) {
        this.versiculoId = versiculoId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}