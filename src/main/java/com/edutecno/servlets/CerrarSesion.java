package com.edutecno.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/CerrarSesion")
public class CerrarSesion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Utilitaria util = new Utilitaria();
        Optional<String> optionalUsuario = util.obtenerUsuario(req);
        if(optionalUsuario.isPresent()){
            HttpSession session = req.getSession();
            session.invalidate();
        }
        resp.sendRedirect("/ProyectoHoroscopo/login.jsp");*/

        HttpSession session = req.getSession();
        String usuario = (String) session.getAttribute("usuario");
        if (usuario != null) {
            session.invalidate();
        }
        resp.sendRedirect("/ProyectoHoroscopo/login.jsp");
    }
}
