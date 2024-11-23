package com.edutecno.dao;

import com.edutecno.modelo.Horoscopo;
import com.edutecno.modelo.Usuario;
import com.edutecno.procesaconexion.ConexionBDPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HoroscopoDAOImp implements HoroscopoDAO {

    private Connection conectar() throws SQLException, ClassNotFoundException {
        return ConexionBDPool.getInstance();
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try (Statement st = conectar().createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM usuarios;")) {
            while(rs.next()) {
                Usuario u = new Usuario(rs.getInt("id_usu"),rs.getString("nombre"),
                        rs.getString("username"),rs.getString("email"),rs.getDate("fecha_nacimiento"),rs.getString("clave"),rs.getString("ani_usu"));
                usuarios.add(u);
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public Optional<Usuario> porId(Integer id) {
        Optional<Usuario> optionalUsuario = null;
        try (Statement st = conectar().createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE id_usu = "+id+";")) {
            if(rs.next()){
                optionalUsuario = Optional.of(new Usuario(rs.getInt("id_usu"),rs.getString("nombre"),
                        rs.getString("username"),rs.getString("email"),rs.getDate("fecha_nacimiento"),rs.getString("clave"),rs.getString("ani_usu")));
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return optionalUsuario;
    }

    @Override
    public Boolean agregar(Usuario u) {
        String sql = "INSERT INTO usuarios (nombre, username, email, fecha_nacimiento, clave, ani_usu) VALUES ("
                + "'" + u.getNombre() + "', "
                + "'" + u.getUsername() + "', "
                + "'" + u.getEmail() + "', "
                + "'" + u.getFechaNacFormateada() + "', "
                + "'" + u.getClave() + "', "
                + "'" + u.getAnimal() + "');";
        try (Statement st = conectar().createStatement()){
            st.execute(sql);
            return true;
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean eliminar(Integer id) {
        String sql = "DELETE FROM usuarios WHERE id_usu = "+id+";";
        try (Statement st = conectar().createStatement()) {
            st.execute(sql);
            return true;
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean actualizar(Usuario u) {
        String sql = "UPDATE usuarios SET nombre = '" + u.getNombre() + "', " +
                "username = '" + u.getUsername() + "', " +
                "email = '" + u.getEmail() + "', " +
                "fecha_nacimiento = '" + u.getFechaNacFormateada() + "', " +
                "clave = '" + u.getClave() + "', " +
                "ani_usu = '" + u.getAnimal() + "' " +
                "WHERE id_usu = " + u.getId() + ";";
        try(Statement st = conectar().createStatement()){
            st.execute(sql);
            return true;
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Horoscopo> obtenerHoroscopo() {
        List<Horoscopo> horoscopos = new ArrayList<Horoscopo>();
        try (Statement st = conectar().createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM horoscopo;")) {
            while(rs.next()) {
                Horoscopo h = new Horoscopo(rs.getInt("id_hor"),rs.getString("ani_hor"),
                        rs.getDate("fecha_inicio"),rs.getDate("fecha_fin"));
                horoscopos.add(h);
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return horoscopos;

    }
}
