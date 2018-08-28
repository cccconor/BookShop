/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DbConnect.DbCon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZJX
 */
@WebServlet(name = "loginck", urlPatterns = {"/loginck"})
public class loginck extends HttpServlet {

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
        doPost(request,response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginck</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginck at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginck</title>");            
            out.println("</head>");
            out.println("<body>");
            
        String use = request.getParameter("Use");
        String psd = request.getParameter("Psd");
//        System.out.print(use);
 //       System.out.print(psd);
        DbCon db = new DbCon();
        String sql = "select LoginPwd from Users where Name = '" + use + "'";
        ResultSet r = db.executeQuery(sql);
        if(r.next()&&r.getString(1).equals(psd)) {
//             out.println("<script language ='javaScript'>alert('登陆，请重试！');</script>");
            response.setHeader("refresh", "0;url=main.jsp");
        }
         else   {
            out.println("<script language ='javaScript'>alert('登陆失败，请重试！');</script>");
            //response.sendRedirect("main.jsp");
            response.setHeader("refresh", "0;url=login.html");
        }
         out.println("</body>");
         out.println("</html>");
        
            
        } catch (SQLException ex) {
            System.out.print(ex);
            Logger.getLogger(loginck.class.getName()).log(Level.SEVERE, null, ex);
        }
        //processRequest(request, response);
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
