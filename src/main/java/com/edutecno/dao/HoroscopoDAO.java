package com.edutecno.dao;

import com.edutecno.modelo.Horoscopo;
import com.edutecno.modelo.Usuario;
import java.util.List;

public interface HoroscopoDAO<T> {
    List<T> listar();
    T porId(Integer id);
    T agregar(Usuario u);
    T eliminar(Integer id);
    T actualizar(Usuario u);
    T obtenerHoroscopo();
}
