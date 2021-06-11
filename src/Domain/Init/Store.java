/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Init;

import Domain.Sales.Catalog;
import Domain.Sales.Register;
import UI.Swing.processSaleJFrame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boud-
 */
public class Store {
    static String CountryName;
    private Catalog pc;
    
    private Store(String CountryName) {
        Store.CountryName = CountryName;
    }

    public Register getRegister() throws SQLException, ClassNotFoundException {
        return new Register(pc);
    }

    public static String getCountryName() {
        return CountryName;
    }
    
    public static final Store INSTANCE = new Store(Store.CountryName);
    
    public static void create() throws SQLException, ClassNotFoundException{
        // Store is the initial domain object. It creates other objects.
        Store store = new Store("Lebanon");
        System.out.println(Store.INSTANCE);
        // Register is reponsible for Process sale transaction
        Register register = store.getRegister();
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(processSaleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new processSaleJFrame(register).setVisible(true);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(processSaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Store.create();
    }
}
