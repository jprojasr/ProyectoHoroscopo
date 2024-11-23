package com.edutecno.servlets;

import com.edutecno.dao.HoroscopoDAOImp;
import com.edutecno.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/Buscar")
public class BuscarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        HoroscopoDAOImp horoscopoDAOImp = new HoroscopoDAOImp();
        List<Usuario> usuarios = horoscopoDAOImp.listar();
        req.setAttribute("usuarios",usuarios);
        getServletContext().getRequestDispatcher("/listar.jsp?id="+id).forward(req,resp);
    }
}
