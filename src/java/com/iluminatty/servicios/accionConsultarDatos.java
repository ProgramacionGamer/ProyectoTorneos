/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iluminatty.servicios;

import com.google.gson.Gson;
import com.iluminatty.basedatos.dao.CiudadDAO;
import com.iluminatty.basedatos.dao.PerfilUsuarioDAO;
import com.iluminatty.basedatos.dao.TipoDocumentosDAO;
import com.iluminatty.basedatos.dao.UsuarioDAO;
import com.iluminatty.basedatos.vo.PerfilUsuarioVO;
import com.iluminatty.utilidades.Constantes;
import com.iluminatty.utilidades.Mensajes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabian Castro <fabicastro89 at gmail.com>
 */
public class accionConsultarDatos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("opcion");
            //out.println(consultarCiudades());
            switch (accion) {
                case "ciudades":
                    out.println(consultarCiudades());
                    break;
                case "tiposDoc":
                    out.println(consultarTiposDocumento());
                    break;
                case "verificarLogin":
                    String correo = request.getParameter("usuario");
                    String password = request.getParameter("pass");
                    out.println(verificarUsaurio(request,correo,password));
                    break;
                case "datosPerfilUsuario":
                    String docUsu = (String)request.getSession().getAttribute("docUsu");
                    out.println(consultarPerfilUsuario(docUsu));
                    break;
                default:
                    out.print("ERROR");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String consultarCiudades() {
        CiudadDAO dao = new CiudadDAO();
        ArrayList arr = dao.consultarCiudades();

        Gson gson = new Gson();
        return gson.toJson(arr);
    }

    private String consultarTiposDocumento() {
        TipoDocumentosDAO dao = new TipoDocumentosDAO();
        ArrayList arr = dao.consultarTiposDocumento();

        Gson gson = new Gson();
        return gson.toJson(arr);
    }

    private String verificarUsaurio(HttpServletRequest request,String correo,String pass) {
        UsuarioDAO dao = new UsuarioDAO();
        Mensajes mensaje = new Mensajes();
        String docUsu= dao.validarUsuarioPass(correo, pass);
        if (!docUsu.equalsIgnoreCase("NN")){
            mensaje.setCodigo(Constantes.CODIGO_OK);
            request.getSession().setAttribute("docUsu", docUsu);
            if(dao.consultarAdmins(docUsu)){
                mensaje.setMensaje("adm");
                request.getSession().setAttribute("tipoUsu", "adm");
            }else{
                mensaje.setMensaje("usr");
                request.getSession().setAttribute("tipoUsu", "usr");
            }
        }
        Gson gson = new Gson();
        return gson.toJson(mensaje);
    }

    private String consultarPerfilUsuario(String docUsu) {
        PerfilUsuarioDAO dao = new PerfilUsuarioDAO();
        PerfilUsuarioVO arr = dao.consultarPerfilUsaurio(docUsu);

        Gson gson = new Gson();
        return gson.toJson(arr);
    }

}
