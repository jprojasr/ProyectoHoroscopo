package com.edutecno.servlets;

import com.edutecno.dao.HoroscopoDAOImp;
import com.edutecno.modelo.Horoscopo;
import com.edutecno.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/Consulta")
public class ConsultarHoroscopo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        HoroscopoDAOImp horoscopoDAOImp = new HoroscopoDAOImp();
        Optional<Usuario> usuario = horoscopoDAOImp.porId(id);
        Usuario u = usuario.get();
        List<Horoscopo> listaHoroscopo= horoscopoDAOImp.obtenerHoroscopo();
        Horoscopo horoscopo = null;
        for (Horoscopo temp : listaHoroscopo) {
            if(u.getFecha_nac().after(temp.getFechaInicio()) && u.getFecha_nac().before(temp.getFechaFin())){
                horoscopo = temp;
            }else if(u.getFecha_nac().equals(temp.getFechaInicio()) || u.getFecha_nac().equals(temp.getFechaFin())){
                horoscopo = temp;
            }
        }
        u.setAnimal(horoscopo.getAnimalHoroscopo());
        horoscopoDAOImp.actualizar(u);
        resp.sendRedirect(req.getContextPath() + "/consulta.jsp?id="+u.getId());



    }
}
