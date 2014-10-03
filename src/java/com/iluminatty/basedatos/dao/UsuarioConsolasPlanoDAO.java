/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iluminatty.basedatos.dao;

import com.iluminatty.basedatos.vo.UsuarioConsolasPlanoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class UsuarioConsolasPlanoDAO {

    Conexion conexion;

    public ArrayList<UsuarioConsolasPlanoVO> consultarPlataformasUsuario(String documento) {
        ArrayList<UsuarioConsolasPlanoVO> plataformas = new ArrayList<>();
        try {
            conexion = new Conexion();
            PreparedStatement stat = conexion.getConec().prepareStatement("SELECT plataformas.nombre, usuariosidconsolas.nom_usu_plataforma\n"
                    + "FROM usuariosidconsolas INNER JOIN plataformas ON usuariosidconsolas.id_plataforma = plataformas.id_plataforma\n"
                    + "WHERE usuariosidconsolas.doc_usuario = ?");
            stat.setString(1, documento);
            ResultSet resultado = stat.executeQuery();
            while (resultado.next()) {
                UsuarioConsolasPlanoVO usuPlano = new UsuarioConsolasPlanoVO();
                usuPlano.setNombrePlataforma(resultado.getString("nombre"));
                usuPlano.setIdUsuarioPlataforma(resultado.getString("nom_usu_plataforma"));
                plataformas.add(usuPlano);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try {
                conexion.getConec().close();
            } catch (SQLException ex) {
               
            }
        }
        return plataformas;
    }
}
