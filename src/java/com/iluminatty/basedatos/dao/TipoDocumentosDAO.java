/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iluminatty.basedatos.dao;

import com.iluminatty.basedatos.vo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class TipoDocumentosDAO {

    Conexion conexion;

    public ArrayList<TipoDocumentosVO> consultarTiposDocumento() {
        ArrayList<TipoDocumentosVO> tiposDocumentos = new ArrayList<>();
        try {
            conexion = new Conexion();
            ResultSet resultado = conexion.getConec().prepareStatement("SELECT * FROM tipos_documentos").executeQuery();
            while (resultado.next()) {
                TipoDocumentosVO tipoDoc = new TipoDocumentosVO();
                tipoDoc.setId(resultado.getInt("id"));
                tipoDoc.setNombre(resultado.getString("nombre_doc"));
                tiposDocumentos.add(tipoDoc);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try {
                conexion.getConec().close();
            } catch (SQLException ex) {
               
            }
        }
        return tiposDocumentos;
    }
}
