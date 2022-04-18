package com.examencerticom.service.dto.request;

import java.sql.Date;
import javax.validation.constraints.NotNull;

public class VentaFiltroDto {

    VentaFiltroDto() {
    }
    
    @NotNull
    public Date fecha;

    public Integer pagina;

    public Integer tamanio;
}
