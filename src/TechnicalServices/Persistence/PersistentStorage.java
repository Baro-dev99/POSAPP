/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechnicalServices.Persistence;

import Domain.Sales.Product;
import Domain.Sales.Sale;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boud-
 */
public class PersistentStorage {
    private String createStringProduct = "insert into product values(default,?,?,?)";
    private String deleteByKeyStringProduct = "delete from product where idProduct = ?";
    private String createStringSale = "insert into sale values(default,?,?,?,?,?)";
    
    private PreparedStatement createStmtProduct;
    private PreparedStatement deleteByKeyStmtProduct;
    private PreparedStatement createStmtSale;
    
    private PersistentStorage() {
        try {
            createStmtProduct = MyConnection.getConnection().prepareStatement(createStringProduct);
            deleteByKeyStmtProduct = MyConnection.getConnection().prepareStatement(deleteByKeyStringProduct);
            createStmtSale = MyConnection.getConnection().prepareStatement(createStringSale);
        } catch (SQLException ex) {
            Logger.getLogger(PersistentStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createProduct(Product prod) throws SQLException {
        createStmtProduct.setString(1, prod.getDescription());
        createStmtProduct.setDouble(2, prod.getPrice());
        createStmtProduct.setInt(3, prod.getQty());
        createStmtProduct.executeUpdate();
    }
    
    public void deleteByKeyProduct(Product prod) throws SQLException {
        deleteByKeyStmtProduct.setInt(1, prod.getItemId());
        deleteByKeyStmtProduct.executeUpdate();
    }
    
    public void createSale(Sale sale) throws SQLException {
        createStmtSale.setInt(1, sale.getNoItems());
        createStmtSale.setInt(2, sale.getNoQty());
        createStmtSale.setDouble(3, sale.getTotalAmount());
        createStmtSale.setString(4, sale.getPaymentMethod());
        createStmtSale.setTimestamp(5, sale.getTs());
        createStmtSale.executeUpdate();
    }
    
    public static final PersistentStorage INSTANCE = new PersistentStorage();
}
