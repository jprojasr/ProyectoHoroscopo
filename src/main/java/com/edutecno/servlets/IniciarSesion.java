package com.edutecno.servlets;

import com.edutecno.procesaconexion.ConexionBDPool;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet({"/InicioSesion", "/InicioSesionGet"})
public class IniciarSesion extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("usuario");
        String c = req.getParameter("clave");
        boolean mostrarModal = false;
        String mensajeModal = "";
        String sqlUsuario = "SELECT * FROM usuarios WHERE username = '" + u + "'";

        try (Statement st = ConexionBDPool.getInstance().createStatement();
             ResultSet rsUsuario = st.executeQuery(sqlUsuario)) {
            if (rsUsuario.next()) {
                String sqlClave = "SELECT * FROM usuarios WHERE username = '" + u + "' AND clave = '" + c + "'";
                try (ResultSet rsClave = st.executeQuery(sqlClave)) {
                    if (rsClave.next()) {
                        HttpSession session = req.getSession();
                        session.setAttribute("usuario", rsClave.getString("nombre"));
                        resp.sendRedirect(req.getContextPath() + "/menu.jsp?id=" + rsClave.getInt("id_usu"));
                        return;
                    } else {
                        mostrarModal = true;
                        mensajeModal = "Contraseña incorrecta.";
                    }
                }
            } else {
                mostrarModal = true;
                mensajeModal = "Usuario no existe, debe registrarse.";
            }
            req.setAttribute("mostrarModal", mostrarModal);
            req.setAttribute("mensajeModal", mensajeModal);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);

        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en MySQL: " + e.getMessage());
        }
    }


}
