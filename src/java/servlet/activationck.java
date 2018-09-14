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
import serve.user;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ZJX
 */
@WebServlet(name = "activationck", urlPatterns = {"/activationck"})
public class activationck extends HttpServlet {

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
        doGet(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet activationck</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet activationck at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
        HttpSession session = request.getSession();
        String psd = request.getParameter("psd");
        String actcode = request.getParameter("actcode");
        String name = request.getParameter("user");
       // String name =(String) session.getAttribute("name");
        DbCon db = new DbCon();
        String sql = "select * from Users where Name = '"+ name + "'";
        System.out.println(name);
        System.out.println(actcode);
        ResultSet re = db.executeQuery(sql);
        
        if(re.next())
        {
            int id = re.getInt("Id");
            String t = re.getString("LoginPwd");
            System.out.println(t);
            if(id!=0)
            {
                sql = "select ActiveCode from CheckEmail where Id = '" + id +"'";
                ResultSet r2 = db.executeQuery(sql);
                if(r2.next()&&r2.getString("ActiveCode").equals(actcode))
                {
                    sql = "update CheckEmail set Actived = 'true' where Id = '" + id +"'";
                    db.executeQuery(sql);
                    sql = "update Users set UserStateId = 1 where Id = '" + id + "'";
                    db.executeQuery(sql);
                    session.setAttribute("user", name);
                    out.println("<script language ='javaScript'>alert('激活成功！');</script>");
                    response.setHeader("refresh", "0;url=main.jsp");
                }else {
                    out.println("<script language ='javaScript'>alert('激活码错误！');</script>");
                    response.setHeader("refresh", "0;url=activation.html");
                }
            }
        }else {
            out.println("<script language ='javaScript'>alert('用户不存在！');</script>");
            response.setHeader("refresh", "0;url=login.html");
        }
            
        } catch (SQLException ex) {
            System.out.print(ex.getStackTrace());
            ex.printStackTrace();
            Logger.getLogger(activationck.class.getName()).log(Level.SEVERE, null, ex);
        }
        //processRequest(request, response);
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
        doGet(request, response);
        /*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        HttpSession session = request.getSession();
        String psd = request.getParameter("psd");
        String actcode = request.getParameter("actcode");
        String name = request.getParameter("user");
       // String name =(String) session.getAttribute("name");
        DbCon db = new DbCon();
        String sql = "select * from Users where Name = '"+ name + "'";
        System.out.println(name);
        System.out.println(actcode);
        ResultSet re = db.executeQuery(sql);
        
        if(re.next())
        {
            int id = re.getInt("Id");
            String t = re.getString("LoginPwd");
            System.out.println(t);
            if(id!=0)
            {
                sql = "select ActiveCode from CheckEmail where Id = '" + id +"'";
                ResultSet r2 = db.executeQuery(sql);
                if(r2.next()&&r2.getString("ActiveCode").equals(actcode))
                {
                    sql = "update CheckEmail set Actived = 'true' where Id = '" + id +"'";
                    db.executeQuery(sql);
                    sql = "update Users set UserStateId = 1 where Id = '" + id + "'";
                    db.executeQuery(sql);
                    out.println("<script language ='javaScript'>alert('激活成功！');</script>");
                    response.setHeader("refresh", "0;url=main.jsp");
                }else {
                    out.println("<script language ='javaScript'>alert('激活码错误！');</script>");
                    response.setHeader("refresh", "0;url=activation.html");
                }
            }
        }else {
            out.println("<script language ='javaScript'>alert('用户不存在！');</script>");
            response.setHeader("refresh", "0;url=login.html");
        }
            
        } catch (SQLException ex) {
            System.out.print(ex.getStackTrace());
            ex.printStackTrace();
            Logger.getLogger(activationck.class.getName()).log(Level.SEVERE, null, ex);
        }
        //processRequest(request, response);
        */
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
