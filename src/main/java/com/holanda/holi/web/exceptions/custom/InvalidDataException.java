package com.holanda.holi.web.exceptions.custom;

public class InvalidDataException extends RuntimeException{

    private final static long serialVersionUID = 1L;

    public InvalidDataException(String mensaje){
        super(mensaje);
    }
}
