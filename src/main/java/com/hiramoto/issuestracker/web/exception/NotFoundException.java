package com.hiramoto.issuestracker.web.exception;

import java.text.MessageFormat;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(Number id) {
        super(MessageFormat.format("Não foi possível encontrar o objeto com id={0}", id));
    }
    
}
