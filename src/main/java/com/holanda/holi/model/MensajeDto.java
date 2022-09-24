package com.holanda.holi.model;

public class MensajeDto {

    private String fecha;
    private String texto;
    private String autor;

    public MensajeDto(){}

    public MensajeDto(String texto, String autor) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
