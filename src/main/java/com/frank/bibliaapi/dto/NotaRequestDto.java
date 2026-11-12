package com.frank.bibliaapi.dto;

public class NotaRequestDto {
    private Long versiculoId;
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