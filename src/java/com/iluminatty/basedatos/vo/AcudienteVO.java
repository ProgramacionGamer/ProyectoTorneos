/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iluminatty.basedatos.vo;

import java.io.File;

/**
 * 
 * @author Fabian Castro
 */
public class AcudienteVO {
    private String numeroDocumento;
    private String documentoUsuario;
    private int tipoDocumento;
    private String nombre;
    private String apellido;
    private File carta;
    private File fotoDocumento;

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public File getCarta() {
        return carta;
    }

    public void setCarta(File carta) {
        this.carta = carta;
    }

    public File getFotoDocumento() {
        return fotoDocumento;
    }

    public void setFotoDocumento(File fotoDocumento) {
        this.fotoDocumento = fotoDocumento;
    }
}
