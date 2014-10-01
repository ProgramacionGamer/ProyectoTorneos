/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iluminatty.basedatos.dao;

import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class Conexion {
    private Connection conec;

    public Conexion() {
        try {
            InitialContext context = new InitialContext();
            System.out.println("Arrancando ");
            DataSource dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/torneo");
            conec = dataSource.getConnection();
            System.out.println("CARGADO");
        } catch (Exception ex) {
            System.out.println("ERROR");
            ex.printStackTrace();
        }
    }

    public Connection getConec() {
        return conec;
    }
    
    
    
    
    
}
