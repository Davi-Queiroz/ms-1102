package com.github.daviqueiroz.ms.produto.controller;

import com.github.daviqueiroz.ms.produto.dto.ProdutoInputDTO;
import com.github.daviqueiroz.ms.produto.dto.ProdutoResponseDTO;
import com.github.daviqueiroz.ms.produto.entities.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    @GetMapping
    public ResponseEntity <List<ProdutoResponseDTO>> getProduto(){

   List<ProdutoResponseDTO> dto = ProdutoResponseDTO.creaMock();
   return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> createProduto(
        @RequestBody ProdutoInputDTO inputDTO){
            ProdutoResponseDTO dto = new ProdutoResponseDTO(1l,inputDTO.getNome(),inputDTO.getDescricao(),inputDTO.getValor());

            return ResponseEntity.created(null).body(dto);
        }
    }

//            josue.add(new Produto(1L,"Rubra","Paralelepipeto",5.0));
//        josue.add(new Produto(2L,"Smirnoff","Trinagulo",5000.0));
//        josue.add(new Produto(6L,"Aguiar","Resenhador Noturno",55.0));

