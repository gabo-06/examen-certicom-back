package com.examencerticom.mapper;

import com.examencerticom.service.dto.response.VentaListaDto;
import com.examencerticom.entidades.Venta;
import org.springframework.stereotype.Component;

@Component
public class VentaToVentaListaDto implements IMapper<Venta, VentaListaDto> {

    @Override
    public VentaListaDto map(Venta venta) {
        VentaListaDto ventaListaDto = new VentaListaDto();
        ventaListaDto.cliente = venta.getCliente().getNombreCompleto();
        ventaListaDto.fecha = venta.getFecha();
        return ventaListaDto;
    }
}
