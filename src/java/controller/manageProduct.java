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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Product;

/**
 *
 * @author NGUYEN LAN
 */
@WebServlet(name="manageProduct", urlPatterns={"/manage"})
public class manageProduct extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet manageProduct</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet manageProduct at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try {
            DBContext db = new DBContext();
            ArrayList<Product> listP = db.listProduct();
            ArrayList<Category> listC = db.listCategory();
            
            int total = db.numberOfProduct();
            int endP = total / 6;
            int a = 0;
            if(total % 6  != 0){
                endP ++;
                a = total % 6;
            }
            String numberOfPage = request.getParameter("numberOfPage");
            int numP = 0;
            if(numberOfPage == null)
                numP = 1;
            else
                numP = Integer.parseInt(numberOfPage);
            listP = db.productInPage(numP);
            
            request.setAttribute("a", a);
            request.setAttribute("total", total);
            request.setAttribute("numP", numP);
            request.setAttribute("endP", endP);
            request.setAttribute("listP", listP);
            request.setAttribute("listC", listC);
            
            request.getRequestDispatcher("manageProduct.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(manageProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
