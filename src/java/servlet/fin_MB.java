/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import serve.backBook;

/**
 *
 * @author zjx00
 */
@WebServlet(name = "fin_MB", urlPatterns = {"/fin_MB"})
public class fin_MB extends HttpServlet {

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
            out.println("<title>Servlet fin_MB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet fin_MB at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        String title = request.getParameter("btitle");
        
        String author = request.getParameter("bauthor");
          int publisher = Integer.parseInt(request.getParameter("book_publish"));
        
       
        String publishdate = request.getParameter("bpdate");
        
        
        
        
        String isbn = request.getParameter("bisbn");
        String count = request.getParameter("bwcount");
        int wordcount = Integer.parseInt(count);
        // out.println("****");
         
        String pr = request.getParameter("bprice");
        float price = Float.parseFloat(pr);
        String contextdes = request.getParameter("con_des");
        
         //out.println(contextdes);
        String authordes = request.getParameter("au_des");
         //out.println(authordes);
        String editorcomment = request.getParameter("comment");
       // out.println(editorcomment);
        String toc = request.getParameter("toc");
        
       // out.println("*"+ toc);
        int categoryid;
        categoryid = Integer.parseInt(request.getParameter("book_sort"));
       // out.println("*"+ toc);
        
        backBook b = new backBook();
        b.setId(Integer.parseInt(id));
        b.setTitle(title);
        b.setAuthor(author);
        b.setPublisherId(publisher);
        b.setPublishdate(publishdate);
        b.setIsbn(isbn);
        b.setWordcounts(wordcount);
        b.setPrice(price);
        b.setContextdes(contextdes);
         
        b.setAuthordes(authordes);
        b.setEditorcomment(editorcomment);
        b.setToc(toc);
        b.setCategoryId(categoryid);
        
        int w=0;
        try {
            w = b.modifyB(b);
    }   catch (SQLException | ParseException ex) {
            Logger.getLogger(fin_MB.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(w==1){
            out.println("<script language ='javaScript'>alert('修改成功！');</script>");
             out.println("<script language ='javaScript'>window.close();</script>");
        }else {
            out.println("<script language ='javaScript'>alert('修改失败！');</script>");
             response.setHeader("refresh", "0;url=modifyB.jsp?id="+id );
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
