package com.github.daviqueiroz.ms.produto.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class FielMessageDTO {
    private String fieldName;
    private String message;

}
