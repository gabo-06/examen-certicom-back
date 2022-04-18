package com.examencerticom.service.dto.base;

import java.io.Serializable;
import java.util.List;

public class RespuestaPaginadaDto<T> implements Serializable {

    public List<T> lista;

    public Long total;

    public RespuestaPaginadaDto(List<T> lista, Long total) {
        this.lista = lista;
        this.total = total;
    }
}
