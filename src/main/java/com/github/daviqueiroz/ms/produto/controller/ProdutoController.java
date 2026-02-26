package com.github.daviqueiroz.ms.produto.controller;

import com.github.daviqueiroz.ms.produto.dto.ProdutoDTO;
import com.github.daviqueiroz.ms.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    private List<ProdutoDTO> list;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {
        List<ProdutoDTO> list = produtoService.findAllProdutos();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable Long id) {
        ProdutoDTO produtoDTO = produtoService.findProdutoById(id);
        return ResponseEntity.ok(produtoDTO);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> createPrduto(@RequestBody ProdutoDTO produtoDTO) {
        produtoDTO = produtoService.saveProduto(produtoDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(produtoDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(produtoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){
        produtoDTO=produtoService.updateProduto(id,produtoDTO);
        return ResponseEntity.ok(produtoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable long id){
        produtoService.deleteProdutoById(id);
        return ResponseEntity.noContent().build();
    }

}



//            josue.add(new Produto(1L,"Rubra","Paralelepipeto",5.0));
//        josue.add(new Produto(2L,"Smirnoff","Trinagulo",5000.0));
//        josue.add(new Produto(6L,"Aguiar","Resenhador Noturno",55.0));

