/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iluminatty.basedatos.dao;

import com.iluminatty.basedatos.vo.*;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CiudadDAO {
    
    int idCiudad;
    private String nombre;
    int idPais;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
