/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.Category;
import model.Product;

/**
 *
 * @author NGUYEN LAN
 */
public class cartServlet extends HttpServlet {
    ArrayList<Product> listCart = new ArrayList<>();
   
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
            out.println("<title>Servlet cartServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cartServlet at " + request.getContextPath () + "</h1>");
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
            String pid = request.getParameter("pid");
            String remove = request.getParameter("remove");
            String productID = request.getParameter("productID");
            String quantity = request.getParameter("quantity");
            String deleteID = request.getParameter("deleteID");
            String addID = request.getParameter("addID");
            
            Product p = new Product();
            Product productDelete = new Product();
            DBContext  db = new DBContext();
            
            
            
            if(pid != null){
                Cart addC = new Cart(pid);
                db.addToCart(addC);
            }
            
            if(remove != null && remove.equals("remove")){
                Cart deleteC = new Cart(productID);
                db.deleteToCart(deleteC);
            }
            
            
            
            ArrayList<Product> listCart = db.listCart();
            ArrayList<Category> listC = db.listCategory();
            
            
            
            
//            if(pid != null){
//                p = db.getProductByID(pid);
//                HttpSession session = request.getSession();
//                listCart.add(p);
//                
//                if(remove != null && remove.equals("remove")){
//                     productDelete = db.getProductByID(productID);
//                     for (Product x : listCart) {
//                        if(x.getId().equals(db.getProductByID(productID).getId()))
//                            listCart.remove(db.getProductByID(productID));
//                    }
//                    
//                    
//                }
//                
//                //response.getWriter().print(listCart.remove(db.getProductByID(productID)));
//                session.setAttribute("listCart", listCart);
//                session.setMaxInactiveInterval(1728000);
//            }
//            
            //response.getWriter().print("output:"+db.quantityCart(addID));
//            request.setAttribute("p", p);
//            request.setAttribute("listC", listC);
            request.setAttribute("quantity", quantity);
            request.setAttribute("listCart", listCart);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(cartServlet.class.getName()).log(Level.SEVERE, null, ex);
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
