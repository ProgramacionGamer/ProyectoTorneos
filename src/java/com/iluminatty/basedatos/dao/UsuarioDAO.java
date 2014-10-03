/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iluminatty.basedatos.dao;

import com.iluminatty.basedatos.vo.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabian Castro
 */
public class UsuarioDAO {

    Conexion conexion;

    public ArrayList<UsuarioVO> consultarUsuarios() {
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
        }finally{
            try {
                conexion.getConec().close();
            } catch (SQLException ex) {
               
            }
        }
        return usuarios;
    }

    public UsuarioVO consultarUsuario(String docUsu) {
        try {
            conexion = new Conexion();
            PreparedStatement prepStat = conexion.getConec().prepareStatement("SELECT * FROM usuarios where num_documento = ?");
            prepStat.setString(1, docUsu);
            ResultSet resultado = prepStat.executeQuery();
            UsuarioVO usuario = new UsuarioVO();
            while (resultado.next()) {
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
                
            }
            return usuario;

        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try {
                conexion.getConec().close();
            } catch (SQLException ex) {
               
            }
        }
        return null;
    }

    public boolean consultarAdmins(String docUsu) {
        ArrayList<UsuarioVO> usuarios = new ArrayList<>();
        try {
            conexion = new Conexion();
            PreparedStatement prepStat = conexion.getConec().prepareStatement("SELECT * FROM admins where doc_usu = ?");
            prepStat.setString(1, docUsu);
            ResultSet resultado = prepStat.executeQuery();
            while (resultado.next()) {
                return true;
            }
            return false;

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
    
    public String validarUsuarioPass(String correo, String pass) {
        ArrayList<UsuarioVO> usuarios = new ArrayList<>();
        try {
            conexion = new Conexion();
            PreparedStatement prepStat = conexion.getConec().prepareStatement("SELECT * FROM usuarios where correo = ? AND password = ? ");
            prepStat.setString(1, correo);
            prepStat.setString(2, pass);
            ResultSet resultado = prepStat.executeQuery();
            while (resultado.next()) {
                return resultado.getString("num_documento");
            }
            return "NN";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "NN";
        }finally{
            try {
                conexion.getConec().close();
            } catch (SQLException ex) {
               
            }
        }
    }

    public boolean insertarUsuario(UsuarioVO usuario) {
        try {
            conexion = new Conexion();
            PreparedStatement stat = conexion.getConec().prepareStatement("INSERT INTO usuarios(num_documento,tipo_documento,nombre,apellidos,num_celular,fecha_nacimiento,genero,id_ciudad,correo,password,foto_perfil) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            stat.setString(1, usuario.getNumDocumento());
            stat.setInt(2, usuario.getTipoDocumento());
            stat.setString(3, usuario.getNombre());
            stat.setString(4, usuario.getApellidos());
            stat.setString(5, usuario.getNumeroCelular());
            stat.setDate(6, new Date(usuario.getFechaNacimiento().getTime()));
            stat.setString(7, usuario.getGenero());
            stat.setInt(8, usuario.getIdCiudad());
            stat.setString(9, usuario.getCorreo());
            stat.setString(10, usuario.getPassword());
            stat.setString(11, usuario.getFotoPerfil());
            int filasAfectadas = stat.executeUpdate();
            return filasAfectadas > 0;

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

    public boolean updateUsuario(UsuarioVO usuario) {
        try {
            conexion = new Conexion();
            PreparedStatement stat = conexion.getConec().prepareStatement("UPDATE usuarios\n"
                    + "SET nombre=?,apellidos=?,num_celular=?,fecha_nacimiento=?,genero=?,id_ciudad=?,password=?,foto_perfil=?\n"
                    + "WHERE num_documento=?;");

            stat.setString(1, usuario.getNombre());
            stat.setString(2, usuario.getApellidos());
            stat.setString(3, usuario.getNumeroCelular());
            stat.setDate(4, new Date(usuario.getFechaNacimiento().getTime()));
            stat.setString(5, usuario.getGenero());
            stat.setInt(6, usuario.getIdCiudad());
            stat.setString(7, usuario.getPassword());
            stat.setString(8, usuario.getFotoPerfil());
            stat.setString(9, usuario.getNumDocumento());
            int filasAfectadas = stat.executeUpdate();
            return filasAfectadas > 0;

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

    public boolean deleteUsuario(String documentoUsuario) {
        try {
            conexion = new Conexion();
            PreparedStatement stat = conexion.getConec().prepareStatement("DELETE FROM usuarios WHERE num_documento=?");
            stat.setString(1, documentoUsuario);
            int filasAfectadas = stat.executeUpdate();
            return filasAfectadas > 0;

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

}
