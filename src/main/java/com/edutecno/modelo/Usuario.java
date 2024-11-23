package com.edutecno.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Usuario {
    private Integer id;
    private String nombre, username, email, clave, animal;
    private Date fecha_nac;

    public Usuario(Integer id, String nombre, String username, String email, Date fecha_nac, String clave, String animal) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.fecha_nac = fecha_nac;
        this.clave = clave;
        this.animal = animal;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getFechaNacFormateada() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha_nac);
    }
}
