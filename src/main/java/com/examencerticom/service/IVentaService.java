package com.examencerticom.service;

import com.examencerticom.service.dto.base.RespuestaPaginadaDto;
import com.examencerticom.service.dto.response.VentaListaDto;
import java.time.LocalDateTime;

public interface IVentaService {

    public RespuestaPaginadaDto<VentaListaDto> listarVentasFiltrado(LocalDateTime fecha, Integer pagina, Integer tamanio) throws Exception;
}
