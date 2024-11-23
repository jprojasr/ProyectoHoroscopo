package com.edutecno.procesaconexion;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBDPool {
    public static Connection getInstance() throws SQLException, ClassNotFoundException{
        Context initContext = null;
        DataSource ds = null;
        try{
            initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            ds = (DataSource)envContext.lookup("jdbc/mysqlbd");
            return ds.getConnection();
        }catch (NamingException e){
            e.printStackTrace();
        }
        return null;
    }
}
