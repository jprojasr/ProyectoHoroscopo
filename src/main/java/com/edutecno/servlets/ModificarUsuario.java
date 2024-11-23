package com.edutecno.servlets;

import com.edutecno.dao.HoroscopoDAOImp;
import com.edutecno.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Modificar")
public class ModificarUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HoroscopoDAOImp horoscopoDAOImp = new HoroscopoDAOImp();
        String nombre = req.getParameter("nombre");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String fechaForm = req.getParameter("fecha");

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        Date fecha_nac = null;
        try {
            fecha_nac = formatoFecha.parse(fechaForm);
        } catch (ParseException e) {
            System.err.println("Error en el formato de la fecha: " + e.getMessage());
        }

        String clave = req.getParameter("clave");
        String animal = req.getParameter("animal");
        Usuario u = null;

        Integer id;
        try{
            id = Integer.parseInt(req.getParameter("id"));
            u = new Usuario(id,nombre,username,email,fecha_nac,clave,animal);
        }catch (NumberFormatException e){
            id = 0;
            e.printStackTrace();
        }

        if(id > 0){
            horoscopoDAOImp.actualizar(u);

        }
        resp.sendRedirect(req.getContextPath() + "/menu.jsp?id="+id);
    }
}
