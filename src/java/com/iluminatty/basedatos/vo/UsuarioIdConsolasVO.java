/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iluminatty.basedatos.vo;

/**
 * 
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class UsuarioIdConsolasVO {
    private int id;
    private int idPlataforma;
    private String documentoUsuario;
    private String nombreUsuarioPlat;
    private String logo;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
