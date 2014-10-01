/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iluminatty.basedatos.dao;

import com.iluminatty.basedatos.vo.UsuariosIdConsolasVO;
import java.sql.PreparedStatement;

/**
 *
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class UsuariosIdConsolasDAO {

    Conexion conexion;

    public boolean insertarUsuPlataforma(UsuariosIdConsolasVO relacion) {
        try {
            conexion = new Conexion();
            PreparedStatement stat = conexion.getConec().prepareStatement("INSERT INTO plataformas(id_plataforma,doc_usuario,nom_usu_plataforma) VALUES (?,?,?)");
            stat.setInt(1, relacion.getIdPlataforma());
            stat.setString(2, relacion.getDocumentoUsuario());
            stat.setString(3, relacion.getNombreUsuarioPlat());
            int filasAfectadas = stat.executeUpdate();
            return filasAfectadas>0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
