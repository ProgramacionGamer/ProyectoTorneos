/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iluminatty.basedatos.vo;

import java.util.ArrayList;

/**
 * 
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class PerfilUsuarioVO {
    private UsuarioVO usuario;
    private ArrayList<UsuarioIdConsolasVO> listaPlataformas;
    private ArrayList<TorneoVO> listaTorneosIsn;

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public ArrayList<UsuarioIdConsolasVO> getListaPlataformas() {
        return listaPlataformas;
    }

    public void setListaPlataformas(ArrayList<UsuarioIdConsolasVO> listaPlataformas) {
        this.listaPlataformas = listaPlataformas;
    }

    public ArrayList<TorneoVO> getListaTorneosIsn() {
        return listaTorneosIsn;
    }

    public void setListaTorneosIsn(ArrayList<TorneoVO> listaTorneosIsn) {
        this.listaTorneosIsn = listaTorneosIsn;
    }
}
