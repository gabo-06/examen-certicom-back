package com.examencerticom.service;

import com.examencerticom.entidades.Cliente;
import com.examencerticom.repositorios.ClienteRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements BaseService<Cliente> {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public List<Cliente> findAll() throws Exception {
        try {
            List<Cliente> clientes = this.clienteRepository.findAll();
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente findById(Integer id) throws Exception {
        try {
            Optional<Cliente> cliente = this.clienteRepository.findById(id);
            return cliente.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente save(Cliente entity) throws Exception {
        try {
            entity = this.clienteRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente update(Integer id, Cliente entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public boolean delete(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
