/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Taxes;

import Domain.Sales.Register;

/**
 *
 * @author boud-
 */
public class LebanonTax implements TaxADAPTER{

    @Override
    public double TaxPercentage(Register reg) {
        double taxPercentage;
        
        Tax tax;
        tax = reg.getTransferFromDB().findTax("LEBANON");
        taxPercentage = tax.getTaxPercentage();

        return taxPercentage;
    }
    
    public static final LebanonTax INSTANCE = new LebanonTax();
}
