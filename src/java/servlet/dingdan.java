/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import serve.book;
import serve.cart;

/**
 *
 * @author ZJX
 */
@WebServlet(name = "dingdan", urlPatterns = {"/dingdan"})
public class dingdan extends HttpServlet {

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
            out.println("<title>Servlet dingdan</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet dingdan at " + request.getContextPath() + "</h1>");
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
            int uid = Integer.valueOf(request.getParameter("uid"));
//            int bid = Integer.valueOf(request.getParameter("bid"));
            int con = Integer.valueOf(request.getParameter("con"));
            
//　　     String da = f1.format(now);
            
            if(uid!=0)
            {
                double tp=0.0;
                cart c = new cart();
                java.util.Date now=new java.util.Date();
                SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMddkkmm");
//　　     SimpleDateFormat f=newSimpleDateFormat("yyyMMddkkmm");
                String da = f1.format(now);
                da = da+uid;
                c.dingdan4(da, uid, tp);
                for(int i=0;i<con;i++)
                {
                    int bid = Integer.valueOf(request.getParameter("bid"+i));
                    int shu = Integer.valueOf(request.getParameter("shuliang"+i));
                    book b = new book();
                    b = b.getbookbyid(bid);
                    tp = tp+ b.getprice()*shu;
                    
                    c.dingdan(da, bid, shu,b.getprice(),uid);
                }
                    c.dingdan3(da, uid, tp);
                    response.setHeader("refresh", "0;url=dingdan.jsp?uid="+uid+"&odid="+da);
            }else response.setHeader("refresh", "0;url=cart.jsp");
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(dingdan.class.getName()).log(Level.SEVERE, null, ex);
        }
//        processRequest(request, response);
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
