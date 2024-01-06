package com.matheus.produto.config;

import com.matheus.produto.entity.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "cliente", url = "http://localhost:8081/cliente")
public interface ClienteEndpoint {


    @RequestMapping(method = RequestMethod.GET, value = "/todos")
    List<Cliente> listarTodos();
    @RequestMapping(method = RequestMethod.POST, value = "/salvar")
    Cliente salvarCliente(Cliente cliente);
}
