package com.hiramoto.issuestracker.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GenericDTO {

    private List<String> warns = new ArrayList<>();
    private List<String> errors = new ArrayList<>();

    public boolean addWarn(String warn) {
        return warns.add(warn);
    }

    public boolean addError(String error) {
        return errors.add(error);
    }
    
}
