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
import serve.UserInfoBean;

/**
 *
 * @author zjx00
 */
@WebServlet(name = "fin_MU", urlPatterns = {"/fin_MU"})
public class fin_MU extends HttpServlet {

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
            out.println("<title>Servlet fin_MU</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet fin_MU at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("uname");
        String pass = request.getParameter("upst");
        String email = request.getParameter("uemail");
        if(name.length()>0&&pass.length()>0){
        UserInfoBean u = new UserInfoBean();
        u.setId(id);
        u.setName(name);
        u.setPass(pass);
        u.setEmail(email);
        int w=0;
        try {
            w =  u.modifyU(u);
        } catch (SQLException ex) {
            Logger.getLogger(fin_MU.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(w==1){
            out.println("<script language ='javaScript'>alert('修改成功！');</script>");
            response.setHeader("refresh", "0;url=m_user.jsp");
        }else {
            out.println("<script language ='javaScript'>alert('修改失败！');</script>");
            response.setHeader("refresh", "0;url=m_user.jsp" );
        }
        
    }
           else{
             out.println("<script language ='javaScript'>alert('用户名称和密码不能为空！');</script>");
             response.setHeader("refresh", "0;url=m_user.jsp");
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
