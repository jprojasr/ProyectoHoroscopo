package com.edutecno.servlets;

import com.edutecno.dao.HoroscopoDAOImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Eliminar")
public class EliminarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HoroscopoDAOImp horoscopoDAOImp = new HoroscopoDAOImp();
        Integer id;
        try{
            id = Integer.parseInt(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0;
            e.printStackTrace();
        }

        if(id > 0){
            horoscopoDAOImp.eliminar(id);
        }

        boolean mostrarModal = true;
        String mensajeModal = "Cuenta eliminada exitosamente.";
        req.setAttribute("mostrarModal", mostrarModal);
        req.setAttribute("mensajeModal", mensajeModal);
        //resp.sendRedirect(req.getContextPath() + "/login.jsp");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
