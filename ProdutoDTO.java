package com.github.daviqueiroz.ms.produto.dto;

import com.github.daviqueiroz.ms.produto.entities.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoDTO {
    private long id;

    @NotBlank(message = "campo obrigatorio")
    @Size(min=3,max=67,message = "deve ter entre 3 e 67 caracteres")
    private String nome;

    @NotBlank(message = "Campo descrito é requerido")
    @Size(min = 10,message = "o descrito de ver obrigatorio")
    private String descricao;
    @NotBlank(message = "O valor é obrigatorio")
    @Positive(message = "o valor deve ser positivo")
    private Double valor;

    public ProdutoDTO(Produto produto) {
        id = produto.getId();
        nome = produto.getNome();
        descricao = produto.getDescricao();
        valor = produto.getValor();
    }
}
