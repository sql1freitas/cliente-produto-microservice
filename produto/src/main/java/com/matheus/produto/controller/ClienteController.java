package com.matheus.produto.controller;


import com.matheus.produto.config.ClienteEndpoint;
import com.matheus.produto.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto/cliente")
public class ClienteController {
    @Autowired
    ClienteEndpoint clienteEndpoint;


    @GetMapping("listar-clientes")
    public List<Cliente> listarClientes() {
        return clienteEndpoint.listarTodos();
    }

    @PostMapping("/salvar-cliente")
    public Cliente salvarCliente(@RequestBody Cliente cliente){
         return clienteEndpoint.salvarCliente(cliente);
    }


}


