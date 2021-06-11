/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechnicalServices.Persistence;

import Domain.Sales.Product;
import Domain.Taxes.Tax;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boud-
 */
public class TransferFromDB {

    private String findAllStringProduct = "select * from product";
    private String findByKeyStringProduct = "select * from product where idProduct = ?";
    private String findByLikeStringProduct = "select * from product where Description like ? ";
    private String findStringTax = "select * from tax where CountryName= ?";
    
    private PreparedStatement findAllStmtProduct;
    private PreparedStatement findByKeyStmtProduct;
    private PreparedStatement findByLikeStmtProduct;
    private PreparedStatement findStmtTax;
    
    private TransferFromDB() {
        try {
            findAllStmtProduct = MyConnection.getConnection().prepareStatement(findAllStringProduct);
            findByKeyStmtProduct = MyConnection.getConnection().prepareStatement(findByKeyStringProduct);
            findByLikeStmtProduct = MyConnection.getConnection().prepareStatement(findByLikeStringProduct);
            findStmtTax = MyConnection.getConnection().prepareStatement(findStringTax);
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Product> findAllProduct() {
        List<Product> ls = new ArrayList();
        try {
            ResultSet set = findAllStmtProduct.executeQuery();
            int prodId;
            String description;
            double price;
            int qty;
            Product prod;
            
            while (set.next()) {
                prodId = set.getInt(1);
                description = set.getString(2);
                price = set.getDouble(3);
                qty = set.getInt(4);
                
                prod = new Product();
                prod.setItemId(prodId);
                prod.setDescription(description);
                prod.setPrice(price);
                prod.setQty(qty);
                
                ls.add(prod);
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
    
    public Product findByKeyProduct(int idProd) {
        try {
            findByKeyStmtProduct.setInt(0, idProd);
            ResultSet set = findByKeyStmtProduct.executeQuery();
            if (set.next()) {
                Product prod = new Product();
                prod.setItemId(idProd);
                prod.setDescription(set.getString(2));
                prod.setPrice(set.getDouble(3));
                prod.setQty(set.getInt(4));
                
                set.close();
                return prod;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Product findByLikeProduct(String desc) {
        Product prod = null;
        try {
            findByLikeStmtProduct.setString(1, desc);
            ResultSet set = findByLikeStmtProduct.executeQuery();
            
            int prodId;
            String prodDesc;
            double prodPrice;
            int prodQty;
            
            set.next();
            prodId = set.getInt(1);
            prodDesc = set.getString(2);
            prodPrice = set.getDouble(3);
            prodQty = set.getInt(4);
            
            prod = new Product(prodId, prodDesc, prodPrice, prodQty);
            
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return prod;
    }
    
    public Tax findTax(String CountryName) {
        Tax tax = null;
        try {
            findStmtTax.setString(1, CountryName);
            ResultSet set = findStmtTax.executeQuery();

            while (set.next()) {

                tax = new Tax();
                tax.setIdTax(set.getInt(1));
                tax.setTaxPercentage(set.getDouble(2));
                tax.setCountryName(set.getString(3));
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tax;
    }
    
    public static final TransferFromDB INSTANCE = new TransferFromDB();
}
