/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iluminatty.basedatos.vo;

import java.util.Date;

/**
 * 
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class TorneoVO {
    private int id;
    private Date fechaInicio;
    private String nombre;
    private String prefijo;
    private int numeroJugadores;
    private int plataforma;
    private int tipoTorneo;
    private String reglas;
    private String descripcion;
    private String logo;
    private String foto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    public int getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(int plataforma) {
        this.plataforma = plataforma;
    }

    public int getTipoTorneo() {
        return tipoTorneo;
    }

    public void setTipoTorneo(int tipoTorneo) {
        this.tipoTorneo = tipoTorneo;
    }

    public String getReglas() {
        return reglas;
    }

    public void setReglas(String reglas) {
        this.reglas = reglas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
