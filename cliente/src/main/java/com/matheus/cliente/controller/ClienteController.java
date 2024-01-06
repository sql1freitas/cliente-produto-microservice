package com.matheus.cliente.controller;

import com.matheus.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.matheus.cliente.entity.Cliente;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/todos")
    public ResponseEntity <List<Cliente>>  listarTodos(){

        List<Cliente> clientes = clienteService.todosCliente();

        return ResponseEntity.status(HttpStatus.OK).body(clientes);

    }
    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvarCliente (@RequestBody Cliente cliente){

        Cliente newCliente = clienteService.cadastrarCliente(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId (@PathVariable Long id){

        Cliente newCliente = clienteService.listarPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(newCliente);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarCliente (@PathVariable Long id){

        clienteService.deletarCliente(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}





