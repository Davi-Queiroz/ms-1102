package com.github.daviqueiroz.ms.produto.service;

import com.github.daviqueiroz.ms.produto.dto.ProdutoDTO;
import com.github.daviqueiroz.ms.produto.entities.Produto;
import com.github.daviqueiroz.ms.produto.repositores.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ClientInfoStatus;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly=true)
    public List<ProdutoDTO> findAllProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(ProdutoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProdutoDTO findProdutoById(long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException("Rescuro não encontrado id: " + id)
            );
        return new ProdutoDTO(produto);

    }

    @Transactional
    public ProdutoDTO saveProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto();

        copyDtoToProduto(produtoDTO,produto);
        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    private void copyDtoToProduto(ProdutoDTO produtoDTO, Produto produto) {
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setValor(produtoDTO.getValor());
    }

    @Transactional
    public ProdutoDTO updateProduto(long id, ProdutoDTO produtoDTO){
        try
        {
            Produto produto = produtoRepository.getReferenceById(id);
            copyDtoToProduto(produtoDTO,produto);
            produto=produtoRepository.save(produto);
            return new ProdutoDTO(produto);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Recusro nao encontrado. ID: " + id);
        }
    }

    @Transactional
    public void deleteProdutoById(long id){
        if(!produtoRepository.existsById(id)){
            throw  new EntityNotFoundException("Recusro nao encontrado. ID: " + id);
        }
        produtoRepository.deleteById(id);
    }

}
