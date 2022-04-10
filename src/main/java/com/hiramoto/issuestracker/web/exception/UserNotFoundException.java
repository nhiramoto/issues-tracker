package com.hiramoto.issuestracker.web.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(Long id) {
        super("Não foi possível encontrar o usuário com id=" + id);
    }
    
}
