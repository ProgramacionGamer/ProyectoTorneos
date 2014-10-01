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
public class ParticipantesTorneoVO {
    private String docUsuario;
    private int idCodigoTorneo;

    public int getIdCodigoTorneo() {
        return idCodigoTorneo;
    }

    public void setIdCodigoTorneo(int idCodigoTorneo) {
        this.idCodigoTorneo = idCodigoTorneo;
    }

    public String getDocUsuario() {
        return docUsuario;
    }

    public void setDocUsuario(String docUsuario) {
        this.docUsuario = docUsuario;
    }
}
