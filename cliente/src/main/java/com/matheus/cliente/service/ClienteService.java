package com.matheus.cliente.service;

import com.matheus.cliente.entity.Cliente;
import com.matheus.cliente.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;



    public List<Cliente> todosCliente(){

        return clienteRepository.findAll();

    }


    public Cliente cadastrarCliente (Cliente cliente){

         return  clienteRepository.save(cliente);

    }


    public void deletarCliente (Long id){

        clienteRepository.deleteById(id);
    }


    public Cliente listarPorId (Long id){

        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        return clienteOptional.get();

    }
}
