package com.matheus.produto.service;

import com.matheus.produto.entity.Produto;
import com.matheus.produto.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;


    public List<Produto> produtosList(){

        return produtoRepository.findAll();

    }

    public Produto salvarProduto (Produto produto){

        return produtoRepository.save(produto);

    }


    public Produto listarPorId (Long id){

        Optional<Produto> produtoOptional= produtoRepository.findById(id);

        return produtoOptional.get();

    }

    public void deletarProduto (Long id){

        produtoRepository.deleteById(id);

    }
}


