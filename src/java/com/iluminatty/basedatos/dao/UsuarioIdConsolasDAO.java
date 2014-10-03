/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iluminatty.basedatos.dao;

import com.iluminatty.basedatos.vo.TorneoVO;
import com.iluminatty.basedatos.vo.UsuarioIdConsolasVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class UsuarioIdConsolasDAO {

    Conexion conexion;

    public boolean insertarUsuPlataforma(UsuarioIdConsolasVO relacion) {
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
        }finally{
            try {
                conexion.getConec().close();
            } catch (SQLException ex) {
               
            }
        }
    }
    
    public ArrayList<UsuarioIdConsolasVO> consultarPlataformasUsuario(String docUsu){
        ArrayList<UsuarioIdConsolasVO> usuConsolas = new ArrayList<>();
        try {
            conexion = new Conexion();
            PreparedStatement stat = conexion.getConec().prepareStatement("SELECT *\n"
                    + "FROM usuariosidconsolas \n"
                    + "WHERE doc_usuario = ?;");
            stat.setString(1, docUsu);
            ResultSet resultado = stat.executeQuery();
            while (resultado.next()) {
                UsuarioIdConsolasVO usuConsola = new UsuarioIdConsolasVO();
                usuConsola.setId(resultado.getInt("id"));
                usuConsola.setIdPlataforma(resultado.getInt("id_plataforma"));
                usuConsola.setNombreUsuarioPlat(resultado.getString("nom_usu_plataforma"));
                PreparedStatement statPlat = conexion.getConec().prepareStatement("SELECT logo FROM plataformas WHERE id_plataforma = ?");
                statPlat.setInt(1, usuConsola.getIdPlataforma());
                ResultSet r = statPlat.executeQuery();
                if(r.next()){
                    usuConsola.setLogo(r.getString("logo"));
                }
                usuConsolas.add(usuConsola);
            }
            return usuConsolas;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }finally{
            try {
                conexion.getConec().close();
            } catch (SQLException ex) {
               
            }
        }
    }
    
    
}
