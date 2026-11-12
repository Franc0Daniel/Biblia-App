package com.frank.bibliaapi.dto;

public class FavoritoRequestDto {
    private Long versiculoId;

    public FavoritoRequestDto() {}

    public Long getVersiculoId() {
        return versiculoId;
    }

    public void setVersiculoId(Long versiculoId) {
        this.versiculoId = versiculoId;
    }
}