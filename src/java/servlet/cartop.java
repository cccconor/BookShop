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
import serve.cart;
import serve.user;

/**
 *
 * @author ZJX
 */
@WebServlet(name = "cartop", urlPatterns = {"/cartop"})
public class cartop extends HttpServlet {

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
            out.println("<title>Servlet cartop</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cartop at " + request.getContextPath() + "</h1>");
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
            String user = (String)session.getAttribute("user");
//            user u = new user();
//            String uid = (String)session.getAttribute("uid");
            int uid = Integer.valueOf(request.getParameter("uid"));
            int bid = Integer.valueOf(request.getParameter("bid"));
            String op = (String) request.getParameter("ope");
            String page =(String) request.getParameter("page");
            cart c = new cart();
            if(op.equals("add"))
            {
                c.addtocart(uid, bid);
                if(page.equals("b.jsp")){
                    response.setHeader("refresh", "0;url=bookdetails.jsp?id="+bid);
                }else
                response.setHeader("refresh", "0;url=cart.jsp");
            }else if(op.equals("cut"))
            {
                c.cutone(uid, bid);
                response.setHeader("refresh", "0;url=cart.jsp");
            }else if(op.equals("clean"))
            {
                c.cleancart(uid);
                 response.setHeader("refresh", "0;url=cart.jsp");
            }
            
//            String user =  (String)request.getParameter("user");
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(cartop.class.getName()).log(Level.SEVERE, null, ex);
        }
//        processRequest(request, response);
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
