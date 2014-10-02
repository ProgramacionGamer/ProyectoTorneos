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
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class TorneoDAO {

    Conexion conexion;

    public ArrayList<TorneoVO> consultarListaTorneos() {
        ArrayList<TorneoVO> torneos = new ArrayList<>();
        try {
            conexion = new Conexion();
            PreparedStatement stat = conexion.getConec().prepareStatement("SELECT id_torneo,nombre,logo FROM torneo");
            ResultSet resultado = stat.executeQuery();
            while (resultado.next()) {
                TorneoVO torneo = new TorneoVO();
                torneo.setId(resultado.getInt("id_torneo"));
                torneo.setNombre(resultado.getString("nombre"));
                torneo.setLogo(resultado.getString("logo"));
                torneos.add(torneo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return torneos;
    }

    public TorneoVO consultarTorneo(int idTorneo) {
        try {
            conexion = new Conexion();
            PreparedStatement stat = conexion.getConec().prepareStatement("SELECT * FROM torneo WHERE id_torneo = ?");
            stat.setInt(1, idTorneo);
            ResultSet resultado = stat.executeQuery();
            TorneoVO torneo = new TorneoVO();
            while (resultado.next()) {
                torneo.setId(resultado.getInt("id_torneo"));
                torneo.setNombre(resultado.getString("nombre"));
                torneo.setLogo(resultado.getString("logo"));
                torneo.setFoto(resultado.getString("foto"));
                torneo.setPrefijo(resultado.getString("prefijo"));
                torneo.setNumeroJugadores(resultado.getInt("num_players"));
                torneo.setPlataforma(resultado.getInt("plataforma"));
                torneo.setTipoTorneo(resultado.getInt("tipo_torneo"));
                torneo.setReglas(resultado.getString("reglas"));
                torneo.setDescripcion(resultado.getString("descripcion"));

            }
            return torneo;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean insertarTorneo(TorneoVO torneo) {
        try {
            conexion = new Conexion();
            PreparedStatement stat = conexion.getConec().prepareStatement("INSERT INTO torneo(nombre,prefijo,num_players,plataforma,tipo_torneo,reglas,descripcion,logo,foto) VALUES (?,?,?,?,?,?,?,?,?)");
            stat.setString(1, torneo.getNombre());
            stat.setString(2, torneo.getPrefijo());
            stat.setInt(3, torneo.getNumeroJugadores());
            stat.setInt(4, torneo.getPlataforma());
            stat.setInt(5, torneo.getTipoTorneo());
            stat.setString(6, torneo.getReglas());
            stat.setString(7, torneo.getDescripcion());
            stat.setString(8, torneo.getLogo());
            stat.setString(9, torneo.getFoto());
            int filasAfectadas = stat.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateTorneo(TorneoVO torneo) {
        try {
            conexion = new Conexion();
            PreparedStatement stat = conexion.getConec().prepareStatement("UPDATE torneos\n"
                    + "SET nombre=?,prefijo=?,num_players=?,plataforma=?,tipo_torneo=?,reglas=?,descripcion=?,logo=?,foto=?\n"
                    + "WHERE id_torneo=?;");

            stat.setString(1, torneo.getNombre());
            stat.setString(2, torneo.getPrefijo());
            stat.setInt(3, torneo.getNumeroJugadores());
            stat.setInt(4, torneo.getPlataforma());
            stat.setInt(5, torneo.getTipoTorneo());
            stat.setString(6, torneo.getReglas());
            stat.setString(7, torneo.getDescripcion());
            stat.setString(8, torneo.getLogo());
            stat.setString(9, torneo.getFoto());
            stat.setInt(10, torneo.getId());
            int filasAfectadas = stat.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteTorneo(int idTorneo) {
        try {
            conexion = new Conexion();
            PreparedStatement stat = conexion.getConec().prepareStatement("DELETE FROM torneo WHERE id_torneo=?");
            stat.setInt(1, idTorneo);
            int filasAfectadas = stat.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
