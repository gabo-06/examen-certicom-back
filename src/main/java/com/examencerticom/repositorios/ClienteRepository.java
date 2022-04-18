package com.examencerticom.repositorios;

import com.examencerticom.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
