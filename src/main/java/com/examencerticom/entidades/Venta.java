package com.examencerticom.entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Entity
@Table(name = "venta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    public Cliente getCliente() {
        return this.cliente;
    }

    public Date getFecha() {
        return this.fecha;
    }
}
