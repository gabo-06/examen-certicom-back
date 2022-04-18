package com.examencerticom.repositorios;

import com.examencerticom.entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    @Query(value = "SELECT * FROM VENTA WHERE :fecha = '' OR fecha = :fecha ORDER BY fecha DESC LIMIT :start, :size", nativeQuery = true)
    public List<Venta> findAllPaginado(
            @Param("fecha") String fecha,
            @Param("start") Integer start,
            @Param("size") Integer size);
}
