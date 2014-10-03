/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iluminatty.basedatos.dao;

import com.iluminatty.basedatos.vo.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class CodigosTorneoDAO {

    Conexion conexion;

    public boolean guardarCodigosTorneo(ArrayList<String> arr, int idTorneo) {
        try {
            conexion = new Conexion();
            String sql = "INSERT INTO codigos_torneo(id_torneo,codigo) VALUES ";
            StringBuilder build = new StringBuilder(sql);

            for (int j = 0; j < arr.size(); j++) {
                build.append("(?,?)");
                if (j + 1 != arr.size()) {
                    build.append(",");
                }
            }
            PreparedStatement stat = conexion.getConec().prepareStatement(build.toString());
            int param = 0;
            for (int j = 0; j < arr.size(); j++) {
                stat.setInt(++param,idTorneo);
                stat.setString(++param,arr.get(j));
            }

            int filasAfectadas = stat.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                conexion.getConec().close();
            } catch (SQLException ex) {

            }
        }
    }

}
