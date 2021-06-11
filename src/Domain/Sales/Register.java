/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

import Domain.Init.Store;
import Domain.Payments.Adaptee.CashSubmit;
import Domain.Payments.Adaptee.CheckSubmit;
import Domain.Payments.Adaptee.CreditCardSubmit;
import Domain.Payments.MyAdapter;
import TechnicalServices.Persistence.TransferFromDB;
import TechnicalServices.Persistence.PersistentStorage;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author boud-
 */
public class Register {
    private Sale sale;
    private TransferFromDB transferFromDB;
    private PersistentStorage persistentStorage;
    private final Catalog catalog;
    
    public Register(Catalog catalog) throws SQLException, ClassNotFoundException {
        this.catalog = catalog;
        this.persistentStorage = PersistentStorage.INSTANCE;
        this.transferFromDB = TransferFromDB.INSTANCE;
    }
    
    public Sale makeNewSale(int noItems, int totalQty, double totalAmount,String[] Payment, int optionChoosed) {
        sale = new Sale();
        sale.setNoItems(noItems);
        sale.setNoQty(totalQty);
        sale.setTotalAmount(totalAmount);
        sale.setPaymentMethod(Payment[optionChoosed]);
        sale.setTs(new Timestamp(new Date().getTime()));
        
        return sale;
    }

    public String makePayment(MyAdapter adap, String[] Payment, int optionChoosed){
        String mPay="";
        if (Payment[optionChoosed].equals(Payment[0])) {
            adap = new MyAdapter(new CashSubmit());
        } else if (Payment[optionChoosed].equals(Payment[1])) {
            adap = new MyAdapter(new CreditCardSubmit());
        } else {
            adap = new MyAdapter(new CheckSubmit());
        }
        mPay = adap.proceed();
        return mPay;
    }
    
    public Catalog loadCatalog(){
        return catalog;
    }
    
    public TransferFromDB getTransferFromDB() {
        return transferFromDB;
    }

    public void setTransferFromDB(TransferFromDB transferFromDB) {
        this.transferFromDB = TransferFromDB.INSTANCE;
    }

    public PersistentStorage getPersistentStorage() {
        return persistentStorage;
    }

    public void setPersistentStorage(PersistentStorage persistentStorage) {
        this.persistentStorage = PersistentStorage.INSTANCE;
    }
    
    public static String getCountry(){
        return Store.getCountryName();
    }
}
