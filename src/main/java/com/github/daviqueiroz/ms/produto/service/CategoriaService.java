package com.github.daviqueiroz.ms.produto.service;

import com.github.daviqueiroz.ms.produto.dto.CategoriaDTO;
import com.github.daviqueiroz.ms.produto.entities.Categoria;
import com.github.daviqueiroz.ms.produto.exception.ResourceNotFound;
import com.github.daviqueiroz.ms.produto.repositores.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public List<CategoriaDTO> findaAllCategorias(){
        return categoriaRepository.findAll().stream().map(CategoriaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CategoriaDTO findCategoriaBYiD(long id){
        Categoria categoria=categoriaRepository.findById(id).orElseThrow(
        () -> new ResourceNotFound("Recurso não encontrado": " + id));
    return new CategoriaDTO(categoria);

    }


}
