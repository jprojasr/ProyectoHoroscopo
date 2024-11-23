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
import java.util.Calendar;
import java.util.Date;

@WebServlet("/Registro")
public class CrearUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date fechaNac = null;
        Calendar gestionFecha;
        SimpleDateFormat formatoFecha;
        formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        gestionFecha = Calendar.getInstance();
        try {
            fechaNac = formatoFecha.parse(req.getParameter("fecha"));
            gestionFecha.setTime(fechaNac);
        } catch (ParseException e) {
            System.err.println("Error en el formato: " + e.getMessage());
        }
        String nombre = req.getParameter("nombre");
        String email = req.getParameter("email");
        String usuario = req.getParameter("usuario");
        String clave = req.getParameter("clave");
        String animal = "No consultado";
        Usuario u = new Usuario(null,nombre,usuario,email,fechaNac,clave,animal);
        HoroscopoDAOImp horoscopoDAOImp = new HoroscopoDAOImp();
        Boolean respuesta = horoscopoDAOImp.agregar(u);
        boolean mostrarModal = true;
        String mensajeModal = "Registro correcto.";

        if (respuesta) {
            req.setAttribute("mostrarModal", mostrarModal);
            req.setAttribute("mensajeModal", mensajeModal);
            //resp.sendRedirect(req.getContextPath() + "/login.jsp");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            System.err.println("Error al agregar el usuario.");
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al agregar un usuario a la BD.");
        }
    }
}
