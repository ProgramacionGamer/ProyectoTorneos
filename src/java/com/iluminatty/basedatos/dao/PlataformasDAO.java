/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iluminatty.basedatos.dao;

import com.iluminatty.basedatos.vo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class PlataformasDAO {

    Conexion conexion;

    public ArrayList<PlataformasVO> consultarPlataformas() {
        ArrayList<PlataformasVO> plataformas = new ArrayList<>();
        try {
            conexion = new Conexion();
            ResultSet resultado = conexion.getConec().prepareStatement("SELECT * FROM plataformas").executeQuery();
            while (resultado.next()) {
                PlataformasVO plataforma = new PlataformasVO();
                plataforma.setIdPlataforma(resultado.getInt("id_plataforma"));
                plataforma.setNombre(resultado.getString("nombre"));
                plataformas.add(plataforma);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try {
                conexion.getConec().close();
            } catch (SQLException ex) {
               
            }
        }
        return plataformas;
    }

    public boolean insertarPlataforma(String nombre) {
        try {
            conexion = new Conexion();
            int filasAfectadas = conexion.getConec().prepareStatement("INSERT INTO plataformas(nombre) VALUES (?)").executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }finally{
            try {
                conexion.getConec().close();
            } catch (SQLException ex) {
               
            }
        }
    }    
}
