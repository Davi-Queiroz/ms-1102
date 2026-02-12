package com.github.daviqueiroz.ms.produto.dto;

import jakarta.servlet.http.PushBuilder;

import java.util.List;

public class ProdutoResponseDTO {

    private long id;
    private String nome;
    private String descricao;
    private Double valor;


    public ProdutoResponseDTO(long id, String nome, String descricao, Double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public static List<ProdutoResponseDTO> creaMock() {
        return List.of(
                new ProdutoResponseDTO(1L, "Rubra", "Paralelepipeto", 5.0),
                new ProdutoResponseDTO(2L, "Smirnoff", "Trinagulo", 5000.0),
                new ProdutoResponseDTO(6L, "Aguiar", "Resenhador Noturno", 55.0)
        );
    }
}
