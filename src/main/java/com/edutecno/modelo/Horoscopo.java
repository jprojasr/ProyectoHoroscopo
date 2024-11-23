package com.edutecno.modelo;

import java.util.Date;

public class Horoscopo {
    private Integer id_hor;
    private String animalHoroscopo;
    private Date fechaInicio, fechaFin;

    public Horoscopo(Integer id_hor, String animalHoroscopo, Date fechaInicio, Date fechaFin) {
        this.id_hor = id_hor;
        this.animalHoroscopo = animalHoroscopo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Horoscopo() {
    }

    public Integer getId_hor() {
        return id_hor;
    }

    public void setId_hor(Integer id_hor) {
        this.id_hor = id_hor;
    }

    public String getAnimalHoroscopo() {
        return animalHoroscopo;
    }

    public void setAnimalHoroscopo(String animalHoroscopo) {
        this.animalHoroscopo = animalHoroscopo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
