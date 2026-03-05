package com.github.daviqueiroz.ms.produto.dto;

import com.github.daviqueiroz.ms.produto.entities.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoriaDTO {
    private Long id;

    @NotBlank(message = "Campo não pode ser vazio")
    @Size(min = 2, max=20,message = "o nome de ter entre 2 e 20 caracteres")
    private String nome;

    public CategoriaDTO(Categoria categoria){
        id= categoria.getId();
        nome=categoria.getNome();
    }

}
