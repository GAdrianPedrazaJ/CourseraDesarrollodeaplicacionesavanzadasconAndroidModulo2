package com.example.petagram;

public class Foto {
    private String url;
    private String descripcion;

    public Foto(String url, String descripcion) {
        this.url = url;
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
