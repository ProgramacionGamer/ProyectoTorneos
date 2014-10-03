/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iluminatty.basedatos.dao;

import com.iluminatty.basedatos.vo.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class CiudadDAO {

    Conexion conexion;

    public ArrayList<CiudadVO> consultarCiudades() {
        ArrayList<CiudadVO> usuarios = new ArrayList<>();
        try {
            conexion = new Conexion();
            ResultSet resultado = conexion.getConec().prepareStatement("SELECT * FROM ciudad").executeQuery();
            while (resultado.next()) {
                CiudadVO ciudad = new CiudadVO();
                ciudad.setIdCiudad(resultado.getInt("id_ciudad"));
                ciudad.setNombre(resultado.getString("nombre_ciudad"));
                usuarios.add(ciudad);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }

}
