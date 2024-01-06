package com.matheus.produto.controller;

import com.matheus.produto.config.ClienteEndpoint;
import com.matheus.produto.entity.Cliente;
import com.matheus.produto.entity.Produto;
import com.matheus.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;
    @Autowired
    ClienteEndpoint clienteEndpoint;
    @GetMapping("/todos")
    public ResponseEntity<List<Produto>> listarTodos (){

        List<Produto> produtoList = produtoService.produtosList();

        return ResponseEntity.status(HttpStatus.OK).body(produtoList);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> listarPorId(@PathVariable Long id){

        Produto produtoid = produtoService.listarPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(produtoid);

    }
    @PostMapping("/salvar")
    public ResponseEntity<Produto> salvarProduto (@RequestBody Produto produto) {

        Produto newProduto = produtoService.salvarProduto(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newProduto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarProduto (@PathVariable Long id){

        produtoService.deletarProduto(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
