package com.matheus.produto.repository;

import com.matheus.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
}
