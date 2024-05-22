/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author NGUYEN LAN
 */
@WebServlet(name = "fixServlet", urlPatterns = {"/fix"})
public class fixServlet extends HttpServlet {

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
            out.println("<title>Servlet fixServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet fixServlet at " + request.getContextPath() + "</h1>");
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


        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String detail = request.getParameter("detail");
           
            
            String image1 = request.getParameter("image1");
            String image2 = request.getParameter("image2");
            String image3 = request.getParameter("image3");
            String image4 = request.getParameter("image4");
            String cateID = request.getParameter("cid");
            
            
             String price = request.getParameter("price");
            float price_nb = 0;
            
            if(price != null && !price.isEmpty()){
                price_nb = Float.parseFloat(price);
                if(price_nb <= 0){
                    request.setAttribute("mess", "Price have to is number > 0");
                    request.setAttribute("id", id);
            
                    request.getRequestDispatcher("edit").forward(request, response);
                }else{
                    Product p = new Product(id, name, detail, price_nb, image1, image2, image3, image4, cateID);
                    DBContext db = new DBContext();
                    db.editProduct(p);
                    response.sendRedirect("manage");
                }
            }
          
            
            
            //request.getRequestDispatcher("manage").forward(request, response);
            
            

        } catch (SQLException ex) {
            Logger.getLogger(editServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

//          try {
//            String id = request.getParameter("id");
//            String name = request.getParameter("name");
//            String detail = request.getParameter("detail");
//            float price = Float.parseFloat(request.getParameter("price"));
//            int size = Integer.parseInt(request.getParameter("size"));
//            String color = request.getParameter("color");
//            String image1 = request.getParameter("image1");
//            String image2 = request.getParameter("image2");
//            String image3 = request.getParameter("image3");
//            String image4 = request.getParameter("image4");
//            String cateID = request.getParameter("cid");
//            
//            Product p = new Product(id, name, detail, price, size, color, image1, image2, image3, image4, cateID);
//            DBContext db = new DBContext();
//            db.editProduct(p);
//            
//            request.getRequestDispatcher("manage").forward(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(editServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
