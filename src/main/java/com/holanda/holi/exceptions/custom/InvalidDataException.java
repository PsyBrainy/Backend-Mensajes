package com.holanda.holi.exceptions.custom;

public class InvalidDataException extends RuntimeException{

    private final static long serialVersionUID = 1L;

    public InvalidDataException(String mensaje){
        super(mensaje);
    }
}
