/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iluminatty.basedatos.dao;

import com.iluminatty.basedatos.vo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fabian Castro
 */
public class UsuarioDAO {
    Conexion conexion;
    
    public ArrayList<UsuarioVO> consultarUsuarios(){
        ArrayList<UsuarioVO> usuarios = new ArrayList<>();
        try {
            conexion = new Conexion();
            ResultSet resultado = conexion.getConec().prepareStatement("SELECT * FROM usuarios").executeQuery();
            while (resultado.next()) {
                UsuarioVO usuario = new UsuarioVO();
                usuario.setNumDocumento(resultado.getString("num_documento"));
                usuario.setTipoDocumento(resultado.getInt("tipo_documento"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setApellidos(resultado.getString("apellidos"));
                usuario.setNumeroCelular(resultado.getString("num_celular"));
                usuario.setFechaNacimiento(resultado.getDate("fecha_nacimiento"));
                usuario.setGenero(resultado.getString("genero"));
                usuario.setIdCiudad(resultado.getInt("id_ciudad"));
                usuario.setCorreo(resultado.getString("correo"));
                usuario.setPassword(resultado.getString("password"));
                usuario.setFotoPerfil(resultado.getString("foto_perfil"));
                usuarios.add(usuario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }
    
    public ArrayList<UsuarioVO> consultarUsuPorCorreo(String correo){
        ArrayList<UsuarioVO> usuarios = new ArrayList<>();
        try {
            conexion = new Conexion();
            PreparedStatement prepStat = conexion.getConec().prepareStatement("SELECT * FROM usuarios where correo = ?");
            prepStat.setString(1, correo);
            ResultSet resultado = prepStat.executeQuery();
            while (resultado.next()) {
                UsuarioVO usuario = new UsuarioVO();
                usuario.setNumDocumento(resultado.getString("num_documento"));
                usuario.setTipoDocumento(resultado.getInt("tipo_documento"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setApellidos(resultado.getString("apellidos"));
                usuario.setNumeroCelular(resultado.getString("num_celular"));
                usuario.setFechaNacimiento(resultado.getDate("fecha_nacimiento"));
                usuario.setGenero(resultado.getString("genero"));
                usuario.setIdCiudad(resultado.getInt("id_ciudad"));
                usuario.setCorreo(resultado.getString("correo"));
                usuario.setPassword(resultado.getString("password"));
                usuario.setFotoPerfil(resultado.getString("foto_perfil"));
                usuarios.add(usuario);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }
    
    public boolean validarUsuarioPass(String correo,String pass){
        ArrayList<UsuarioVO> usuarios = new ArrayList<>();
        try {
            conexion = new Conexion();
            PreparedStatement prepStat = conexion.getConec().prepareStatement("SELECT * FROM usuarios where correo = ? AND password = ? ");
            prepStat.setString(1, correo);
            prepStat.setString(2, pass);
            ResultSet resultado = prepStat.executeQuery();
            while (resultado.next()) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
    
