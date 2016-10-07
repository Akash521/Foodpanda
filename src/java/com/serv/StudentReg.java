/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serv;

import com.ejb.Entity1Facade;
import com.entity.Entity1;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vaio
 */
@WebServlet(name = "StudentReg", urlPatterns = {"/StudentReg"})
public class StudentReg extends HttpServlet {

    @EJB
    private Entity1Facade entity1Facade;

    
    
    
    private static final Logger LOG = Logger.getLogger(StudentReg.class.getName());
//    static final DateFormat DATA__FORMAT_DD_MM_YYYY=new SimpleDateFormat("dd/mm/yyyy");

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String name =request.getParameter("name");
        String password=request.getParameter("password");
        String phoneno=request.getParameter("phoneno");
        String sex =request.getParameter("sex");
        String email =request.getParameter("email");
        LOG.log(Level.INFO,"Name:{0}",name);
        LOG.log(Level.INFO,"password:{0}",password);
        LOG.log(Level.INFO,"phoneno:{0}",phoneno);
        LOG.log(Level.INFO,"Sex:{0}",sex);
        LOG.log(Level.INFO,"email:{0}",email);
        Entity1 entity=new Entity1();
        entity.setName(name);
        entity.setPassword(password);
        entity.setPhoneno(phoneno);
        entity.setEmail(email);
        entity.setSex(sex);
        entity1Facade.create(entity);
        LOG.log(Level.INFO, "Entity {0}",entity);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentReg</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentReg at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

}
