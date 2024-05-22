package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Cart;
import model.Category;
import model.Product;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FPT University - PRJ30X
 */
public class DBContext {
    protected Connection connection;
    public DBContext()
    {
        //@Students: You are allowed to edit user, pass, url variables to fit 
        //your system configuration
        //You can also add more methods for Database Interaction tasks. 
        //But we recommend you to do it in another class
        // For example : StudentDBContext extends DBContext , 
        //where StudentDBContext is located in dal package, 
        try {
            String user = "sa";
            String pass = "Kimquy0988";
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Assignment";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBContext db = new DBContext(); // khởi tạo 1 lớp DBContext, trong class db thì có nhiều hàm
        
        //System.out.println(db.listCategory());
        //System.out.println(db.listProduct());
        //System.out.println(db.searchProductByCateID("DE"));
        //System.out.println(db.getProductByID("DE00"));
        //System.out.println(db.searchProductByName("pant"));
        //System.out.println(db.login("lan@gmail.com", "haha0988"));
        //System.out.println(db.checkEmail("lan@gmail.com"));
        //db.deleteProduct("DE03");
        
        //Product p = new Product("je01", "jean", "haha", 20, "haa1", "hhaa2", "haha3", "haha4", "JE");
//        db.addProduct(p);
        // db.editProduct(p);
       // System.out.println(db.numberOfProduct());
        //System.out.println(db.productInPage(1));
        //System.out.println(db.trendyProduct());
        Cart c = new Cart("JE01");
        //System.out.println(db.addToCart(c));
        //System.out.println(db.listCart());
        //db.deleteToCart(c);
            //System.out.println(db.listCart());
            System.out.println(db.quantityCart("JE01"));
    }
    
    
    public ArrayList<Category> listCategory() throws SQLException{
        ArrayList<Category> list = new ArrayList<>();
        
        String sql = "select * from Category";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            
            Category c = new Category(id, name);
            list.add(c);
        }
        return list;
    }
    
    
    public ArrayList<Product> listProduct() throws SQLException{
        ArrayList<Product> listP = new ArrayList<>();
        
        String sql = "select * from Product";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String detail = rs.getString(3);
            Float price = rs.getFloat(4);
            String image1 = rs.getString(5);
            String image2 = rs.getString(6);
            String image3 = rs.getString(7);
            String image4 = rs.getString(8);
            String cateID = rs.getString(9);
            
            Product p = new Product(id, name, detail, price,image1, image2, image3, image4, cateID);
            listP.add(p);
        }
        return listP;
    }    
    
    public ArrayList<Product> trendyProduct() throws SQLException{
        ArrayList<Product> listP = new ArrayList<>();
        
        String sql = "select top 4 * from Product order by ProductPrice desc";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String detail = rs.getString(3);
            Float price = rs.getFloat(4);
            
            String image1 = rs.getString(5);
            String image2 = rs.getString(6);
            String image3 = rs.getString(7);
            String image4 = rs.getString(8);
            String cateID = rs.getString(9);
            
            Product p = new Product(id, name, detail, price, image1, image2, image3, image4, cateID);
            listP.add(p);
        }
        return listP;
    }    
    
    public ArrayList<Product> outstandingProduct() throws SQLException{
        ArrayList<Product> listP = new ArrayList<>();
        
        String sql = "select top 8 * from Product order by ProductPrice asc";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String detail = rs.getString(3);
            Float price = rs.getFloat(4);
          
            String image1 = rs.getString(5);
            String image2 = rs.getString(6);
            String image3 = rs.getString(7);
            String image4 = rs.getString(8);
            String cateID = rs.getString(9);
            
            Product p = new Product(id, name, detail, price,image1, image2, image3, image4, cateID);
            listP.add(p);
        }
        return listP;
    }
    
    
    public ArrayList<Product> searchProductByCateID(String cateId) throws SQLException{
        ArrayList<Product> listProductByCateID = new ArrayList<>();
        
        String sql = "select * from Product where CategoryID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
       // ResultSet rs = statement.executeQuery();
       statement.setString(1, cateId);
        
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String detail = rs.getString(3);
            Float price = rs.getFloat(4);
            
              String image1 = rs.getString(5);
            String image2 = rs.getString(6);
            String image3 = rs.getString(7);
            String image4 = rs.getString(8);
            String cateID = rs.getString(9);
            
            Product p = new Product(id, name, detail, price, image1, image2, image3, image4, cateID);
            listProductByCateID.add(p);
        }
        return listProductByCateID;
    }
    
    public Product getProductByID(String productID) throws SQLException{
        //ArrayList<Product> getProductByID = new ArrayList<>();
       
        
        String sql = " select * from Product where ProductID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
       // ResultSet rs = statement.executeQuery();
       statement.setString(1, productID);
        
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String detail = rs.getString(3);
            Float price = rs.getFloat(4);
          
            String image1 = rs.getString(5);
            String image2 = rs.getString(6);
            String image3 = rs.getString(7);
            String image4 = rs.getString(8);
            String cateID = rs.getString(9);
            Product p = new Product(id, name, detail, price,image1, image2, image3, image4, cateID);
            return p;
        }
        return null;
    }
    
    
    public ArrayList<Product> searchProductByName(String nameS) throws SQLException{
        ArrayList<Product> listProductByName = new ArrayList<>();
        
        String sql = "select * from Product where ProductName like ?";
        PreparedStatement statement = connection.prepareStatement(sql);
       // ResultSet rs = statement.executeQuery();
       statement.setString(1, "%"+nameS+"%");
        
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String detail = rs.getString(3);
            Float price = rs.getFloat(4);
            
             String image1 = rs.getString(5);
            String image2 = rs.getString(6);
            String image3 = rs.getString(7);
            String image4 = rs.getString(8);
            String cateID = rs.getString(9);
            
            Product p = new Product(id, name, detail, price,image1, image2, image3, image4, cateID);
            listProductByName.add(p);
        }
        return listProductByName;
    }
    
    public Account login(String e, String pass) throws SQLException{
        String sql = "select * from Account where Email=? and [Password] = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
       // ResultSet rs = statement.executeQuery();
       statement.setString(1, e);
       statement.setString(2, pass);
        
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String password = rs.getString(4);
            int isSeller = rs.getInt(5);
            
            Account a = new Account(id, name, email, password, isSeller);
            return a;
        }
        return null;
    }
    
    
    
    public void signUp(String user, String email, String pass) throws SQLException{
        String sql = "INSERT INTO Account( AccountName, Email, [Password], isSeller)\n" +
                      "VALUES(?, ?, ?, 0)";
        PreparedStatement statement = connection.prepareStatement(sql);
     //   ResultSet rs = statement.executeQuery();
        
        statement.setString(1, user);
        statement.setString(2, email);
        statement.setString(3, pass);
        
        
        statement.executeUpdate();
       
    }
    
    
    public Account checkEmail(String e) throws SQLException{
        String sql = "select * from Account where Email=?";
        PreparedStatement statement = connection.prepareStatement(sql);
       // ResultSet rs = statement.executeQuery();
       statement.setString(1, e);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String password = rs.getString(4);
            int isSeller = rs.getInt(5);
            
            Account a = new Account(id, name, email, password, isSeller);
            return a;
        }
        return null;
    }
    
     public void deleteProduct(String productID) throws SQLException{
        String sql = "delete from Product where ProductID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
     //   ResultSet rs = statement.executeQuery();
        
        statement.setString(1, productID);
        statement.executeUpdate();
       
    }
    
    public void addProduct(Product p) throws SQLException{
        String sql = "insert into Product(ProductID, ProductName, ProductDetail, ProductPrice,image1,image2, image3, image4, CategoryID)\n" +
                      "Values(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        PreparedStatement statement = connection.prepareStatement(sql);
     //   ResultSet rs = statement.executeQuery();
        
     
     
     
        statement.setString(1, p.getId());
        statement.setString(2, p.getName());
        statement.setString(3, p.getDetail());
        statement.setFloat(4, p.getPrice());
       
        statement.setString(5, p.getImage1());
        statement.setString(6, p.getImage2());
        statement.setString(7, p.getImage3());
        statement.setString(8, p.getImage4());
        statement.setString(9, p.getCateID());
        
        
        
        statement.executeUpdate();
       
    }
    
    public void editProduct(Product p) throws SQLException{
        String sql = "update Product set ProductName = ?, ProductDetail = ?, ProductPrice = ?,  \n" +
                        "image1=?, image2=?, image3=?, image4=?, CategoryID=? where ProductID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
     //   ResultSet rs = statement.executeQuery();
        
     
     
     
      //  statement.setString(1, p.getId());
        statement.setString(1, p.getName());
        statement.setString(2, p.getDetail());
        statement.setFloat(3, p.getPrice());
      //  statement.setInt(, p.getSize());
       // statement.setString(6, p.getColor());
        statement.setString(4, p.getImage1());
        statement.setString(5, p.getImage2());
        statement.setString(6, p.getImage3());
        statement.setString(7, p.getImage4());
        statement.setString(8, p.getCateID());
        statement.setString(9, p.getId());
        
        
        statement.executeUpdate();
       
    }
    
    public int numberOfProduct() throws SQLException{
        //ArrayList<Category> list = new ArrayList<>();
        
        String sql = "select count(*) from Product";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            int number = rs.getInt(1);
            return number;
        }
        return 0;
    }
    
    public ArrayList<Product> productInPage(int index) throws SQLException{
        ArrayList<Product> listProductInPage = new ArrayList<>();
        
        String sql = "select * from Product\n" +
                    "order by ProductID\n" +
                    "offset ? rows fetch next 6 rows only;";
        PreparedStatement statement = connection.prepareStatement(sql);
       // ResultSet rs = statement.executeQuery();
       int page = (index-1)*4;
       statement.setInt(1, page);
        
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String detail = rs.getString(3);
            Float price = rs.getFloat(4);
            
             String image1 = rs.getString(5);
            String image2 = rs.getString(6);
            String image3 = rs.getString(7);
            String image4 = rs.getString(8);
            String cateID = rs.getString(9);
            
            Product p = new Product(id, name, detail, price, image1, image2, image3, image4, cateID);
            listProductInPage.add(p);
        }
        return listProductInPage;
    }
    
//    public void addToCart(String ProductID) throws SQLException{
//        ArrayList<Cart> listCart= new ArrayList<>();
//        
//        String sql = "insert into Cart(ProductID) values(?)";
//        PreparedStatement statement = connection.prepareStatement(sql);
//       // ResultSet rs = statement.executeQuery();
//       statement.setString(1, ProductID);
//        
//        ResultSet rs = statement.executeQuery();
//        while(rs.next()){
//            String id = rs.getString(1);
//            String productID = rs.getString(2);
//            
//        }
//        
//    }
    
    public void addToCart(Cart c) throws SQLException{
        String sql = "insert into Cart(ProductID) values(?)";
        PreparedStatement statement = connection.prepareStatement(sql);
     //   ResultSet rs = statement.executeQuery();
        
        
        statement.setString(1, c.getProductID());
        
        
        statement.executeUpdate();
        
    }
    
    public void deleteToCart(Cart c) throws SQLException{
        String sql = "delete from Cart where ProductID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
     //   ResultSet rs = statement.executeQuery();
        
        
        statement.setString(1, c.getProductID());
        
        
        statement.executeUpdate();
        
    }
    
    
    
     public int quantityCart(String productID) throws SQLException{
        //ArrayList<Category> list = new ArrayList<>();
        
        String sql = "select count(*) from Cart where ProductID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, productID);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            int number = rs.getInt(1);
            return number;
        }
        return 0;
    }
    
    
     public ArrayList<Product> listCart() throws SQLException{
        ArrayList<Product> listP = new ArrayList<>();
        
        String sql = "select p.ProductID, p.ProductName, p.ProductDetail, p.ProductPrice, p.image1, p.image2, p.image3,p.image4,p.CategoryID\n" +
"from Product p inner join Cart c on p.ProductID = c.ProductID";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String detail = rs.getString(3);
            Float price = rs.getFloat(4);
            String image1 = rs.getString(5);
            String image2 = rs.getString(6);
            String image3 = rs.getString(7);
            String image4 = rs.getString(8);
            String cateID = rs.getString(9);
            
            Product p = new Product(id, name, detail, price,image1, image2, image3, image4, cateID);
            listP.add(p);
        }
        return listP;
    }    
    
}

