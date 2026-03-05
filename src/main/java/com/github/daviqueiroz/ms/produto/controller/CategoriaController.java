package com.github.daviqueiroz.ms.produto.controller;

import com.github.daviqueiroz.ms.produto.dto.CategoriaDTO;
import com.github.daviqueiroz.ms.produto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> GetAllCategorias(){
        List<CategoriaDTO> categoria = categoriaService.findaAllCategorias();
        return ResponseEntity.ok(categoria);
    }
}
