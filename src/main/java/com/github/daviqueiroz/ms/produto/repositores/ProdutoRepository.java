package com.github.daviqueiroz.ms.produto.repositores;

import com.github.daviqueiroz.ms.produto.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
