/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import serve.Publishers;

/**
 *
 * @author zjx00
 */
@WebServlet(name = "delPB", urlPatterns = {"/delPB"})
public class delPB extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet delPB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet delPB at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        
        try (PrintWriter out = response.getWriter()) {
            
          //out.println(123);
        String[] delete = request.getParameterValues("chose");
        //out.println(123);
        //int s=delete.length;
        //out.println(123);
        
        int  id;
        
        if(delete==null){
            out.println("<script language ='javaScript'>alert('请选择要删除的出版社');</script>");
           
        }
        
        else{
            //out.print(delete[0]);
            for (String delete1 : delete) {
                id = Integer.parseInt(delete1);
                Publishers p = new Publishers();
                p.setId(id);
                try{
                    p.deleteP(p);
                }catch(SQLException ex) {
                    
                    Logger.getLogger(fin_addPb.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.print(ex.getMessage());
                }       }
            
          
        }
        
          response.setHeader("refresh", "0;url=m_publish.jsp");   
        }
        
        
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
