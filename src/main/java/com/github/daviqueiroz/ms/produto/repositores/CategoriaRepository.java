package com.github.daviqueiroz.ms.produto.repositores;

import com.github.daviqueiroz.ms.produto.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository  extends JpaRepository<Categoria,Long> {
}
