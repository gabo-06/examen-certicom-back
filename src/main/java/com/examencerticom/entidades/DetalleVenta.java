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

@Entity
@Table(name = "detalle_venta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleVenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_venta", referencedColumnName = "id", nullable = false)
    private Venta venta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
}
