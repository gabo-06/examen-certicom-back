package com.examencerticom.service.dto.response;

import java.io.Serializable;
import java.sql.Date;
import java.math.BigDecimal;

public class VentaListaDto implements Serializable {

    public String cliente;

    public Date fecha;

    public BigDecimal total;
}
