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
public class UsuariosIdConsolasVO {
    private int id;
    private int idPlataforma;
    private String documentoUsuario;
    private String nombreUsuarioPlat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(int idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getNombreUsuarioPlat() {
        return nombreUsuarioPlat;
    }

    public void setNombreUsuarioPlat(String nombreUsuarioPlat) {
        this.nombreUsuarioPlat = nombreUsuarioPlat;
    }
}
