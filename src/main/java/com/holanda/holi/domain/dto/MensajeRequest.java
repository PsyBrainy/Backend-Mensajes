package com.holanda.holi.domain.dto;

public class MensajeRequest {

    private String texto;
    private String autor;

    public MensajeRequest(){}

    public MensajeRequest(String texto, String autor) {
        this.texto = texto;
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
