package com.example.proyectbiblioteca.dto.ubicacion;

public class RequestLocationDTO {

    private String piso;
    private String salon;
    private String estante;

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }
}
