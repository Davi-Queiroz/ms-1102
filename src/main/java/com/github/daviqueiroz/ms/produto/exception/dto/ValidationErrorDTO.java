package com.github.daviqueiroz.ms.produto.exception.dto;

import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationErrorDTO extends CustomErrorDTO {
    private List<FielMessageDTO> errors = new ArrayList<>();

    public ValidationErrorDTO(Instant timestamp, Integer status, String error, String path){
        super(timestamp,status,error,path);
    }
public void addEror(String fieldName,String message){
        errors.removeIf(x->x.getFieldName().equals(fieldName));
        errors.add(new FielMessageDTO(fieldName,message));
}

}
