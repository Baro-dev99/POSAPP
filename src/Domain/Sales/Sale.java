/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

import java.sql.Timestamp;

/**
 *
 * @author boud-
 */
public class Sale {
    int idSale;
    int NoItems;
    int NoQty;
    double TotalAmount;
    String PaymentMethod;
    Timestamp ts ;
    
    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getNoItems() {
        return NoItems;
    }

    public void setNoItems(int NoItems) {
        this.NoItems = NoItems;
    }

    public int getNoQty() {
        return NoQty;
    }

    public void setNoQty(int NoQty) {
        this.NoQty = NoQty;
    }

    public double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(double TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "Sale{" + "idSale=" + idSale + ", NoItems=" + NoItems + ", NoQty=" + NoQty + ", TotalAmount=" + TotalAmount + ", PaymentMethod=" + PaymentMethod + ", ts=" + ts + '}';
    }
}
