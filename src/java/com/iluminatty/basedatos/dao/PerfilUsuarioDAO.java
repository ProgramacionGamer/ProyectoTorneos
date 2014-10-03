/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iluminatty.basedatos.dao;

import com.iluminatty.basedatos.vo.PerfilUsuarioVO;

/**
 * 
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class PerfilUsuarioDAO {

    public PerfilUsuarioVO consultarPerfilUsaurio(String docUsu) {
        UsuarioDAO daoUsu = new UsuarioDAO();
        TorneoDAO daoTorn = new TorneoDAO();
        UsuarioIdConsolasDAO daoUsCons = new UsuarioIdConsolasDAO();
        PerfilUsuarioVO perfilUsuario = new PerfilUsuarioVO();
        perfilUsuario.setUsuario(daoUsu.consultarUsuario(docUsu));
        perfilUsuario.setListaTorneosIsn(daoTorn.torneosPorUsaurio(docUsu));
        perfilUsuario.setListaPlataformas(daoUsCons.consultarPlataformasUsuario(docUsu));
        return perfilUsuario;
        
    }
    
}
