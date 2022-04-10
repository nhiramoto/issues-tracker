package com.hiramoto.issuestracker.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Response<E> extends GenericDTO {

    private E entity;

    public Response<E> withError(String error) {
        addError(error);
        return this;
    }
    
}
