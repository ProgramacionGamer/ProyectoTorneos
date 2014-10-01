/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iluminatty.basedatos.vo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CiudadVO {
    
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
