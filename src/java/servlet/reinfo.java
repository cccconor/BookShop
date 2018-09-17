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
import javax.servlet.http.HttpSession;
import serve.user;

/**
 *
 * @author ZJX
 */
@WebServlet(name = "reinfo", urlPatterns = {"/reinfo"})
public class reinfo extends HttpServlet {

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
        doPost(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet reinfo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet reinfo at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            System.out.println((String)request.getParameter("user"));
            String i = (String)request.getParameter("op");
            System.out.println(i);
            if(i.equals("pwd"))
            {
                String user = (String)request.getParameter("user");
                String psd0 = (String)request.getParameter("oldpsd");
                String psd = (String)request.getParameter("newpsd");
                user u = new user();
                u = u.getallinfo(user);
                if(u.getPsd().equals(psd0)){
                    u.setPsd(psd);
                    if(u.repsd(u)==1)
                {
                    
                    out.println("<script language ='javaScript'>alert('密码修改成功！');</script>");
                     response.setHeader("refresh", "0;url=main.jsp");
                }else {
                    out.println("<script language ='javaScript'>alert('密码修改失败，请重试！');</script>");
                     response.setHeader("refresh", "0;url=repsd.jsp");
                }
                }
                else {
                    out.println("<script language ='javaScript'>alert('旧密码错误，请重试！');</script>");
                     response.setHeader("refresh", "0;url=repsd.jsp");
                }
                
            }
            else
            {
                String user = (String)request.getParameter("user");
                String name = (String)request.getParameter("loginid");
                String addr = (String)request.getParameter("addr");
                String phone = (String)request.getParameter("phone");
                String email = (String)request.getParameter("email");
                user u = new user();
                u.setName(user);
                u.setloginid(name);
                u.setaddr(addr);
                u.setPhone(phone);
                u.setEmail(email);
                user u2 = u.upinfo(u);
                if(u2.getName()==u.getName())
                {
                    session.removeAttribute("uid");
                    session.setAttribute("uid",u.getloginid() );
                    out.println("<script language ='javaScript'>alert('用户信息修改成功！');</script>");
                     response.setHeader("refresh", "0;url=main.jsp");
                }else {
                    out.println("<script language ='javaScript'>alert('用户信息修改失败，请重试！');</script>");
                     response.setHeader("refresh", "0;url=repsd.jsp");
                }
                
            }
                
            
            
        //processRequest(request, response);
    }   catch (SQLException ex) {
        ex.printStackTrace();
            Logger.getLogger(reinfo.class.getName()).log(Level.SEVERE, null, ex);
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
