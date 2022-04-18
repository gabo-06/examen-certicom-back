package com.examencerticom.service;

import com.examencerticom.entidades.Venta;
import com.examencerticom.mapper.VentaToVentaListaDto;
import com.examencerticom.repositorios.VentaRepository;
import com.examencerticom.service.dto.base.RespuestaPaginadaDto;
import com.examencerticom.service.dto.response.VentaListaDto;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

@Service
public class VentaService implements IVentaService {

    private final VentaRepository ventaRepository;
    private final VentaToVentaListaDto mapper;
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd";

    public VentaService(VentaRepository ventaRepository, VentaToVentaListaDto mapper) {
        this.ventaRepository = ventaRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public RespuestaPaginadaDto<VentaListaDto> listarVentasFiltrado(LocalDateTime fecha, Integer pagina, Integer tamanio) throws Exception {
        try {
            Integer start = (pagina * tamanio) - tamanio;
            Integer size = tamanio;
            String fechaString = fecha == null ? "" : DateTimeFormatter.ofPattern(DATE_TIME_PATTERN).format(fecha);
            List<Venta> ventas = this.ventaRepository.findAllPaginado(fechaString, start, size);
            List<VentaListaDto> ventasDto = new ArrayList<VentaListaDto>();
            for (Venta venta : ventas) {
                ventasDto.add(this.mapper.map(venta));
            }
            Long totalVentas = this.ventaRepository.count();
            return new RespuestaPaginadaDto<VentaListaDto>(ventasDto, totalVentas);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
